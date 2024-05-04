package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.ChampionPayload;
import com.deux.duohaeduo.dto.request.FindChampionRequest;
import com.deux.duohaeduo.dto.response.FindAllChampionResponse;
import com.deux.duohaeduo.dto.RotationChampionPayload;
import com.deux.duohaeduo.dto.response.FindAllRotationChampionsResponse;
import com.deux.duohaeduo.dto.response.FindByChampionSkinsResponse;
import com.deux.duohaeduo.dto.response.FindChampionResponse;
import com.deux.duohaeduo.dto.riot.champion.Datum;
import com.deux.duohaeduo.dto.riot.champion.Empty;
import com.deux.duohaeduo.entity.Champion;
import com.deux.duohaeduo.repository.ChampionRepository;
import com.deux.duohaeduo.service.webClient.RiotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChampionService {

    private final static int FIRST_INDEX = 0;
    private final static int MIN_CHAMPIONS_REQUIRED = 3;
    private static final long INITIAL_DELAY = 3000;

    private final RiotService riotService;
    private final ChampionRepository championRepository;

    @Transactional(readOnly = true)
    public FindChampionResponse findByChampion(FindChampionRequest findChampionRequest) {
        List<ChampionPayload> champions = championRepository.findByChampionType(findChampionRequest.getAnswers().get(FIRST_INDEX))
                .stream().map(ChampionPayload::from).collect(Collectors.toList());
        champions.forEach(champion -> champion.verifyKeyword(findChampionRequest.getAnswers()));
        champions.sort(Comparator.comparingInt(ChampionPayload::getKeywordCount).reversed());
        return FindChampionResponse.from(getChampions(findMaximumKeywordChampions(champions)));
    }

    /**
     * keywordCount 최댓값 찾기
     *
     * @param championPayloads 챔피언 정보
     * @return 최대값 반환
     */
    private int verifyMaximumKeywordCount(List<ChampionPayload> championPayloads) {
        return championPayloads.stream()
                .mapToInt(ChampionPayload::getKeywordCount)
                .max().orElseThrow(() -> new IllegalArgumentException("조회된 챔피언이 없습니다."));
    }

    /**
     * 최댓값이 같은 챔피언 찾기
     *
     * @param championPayloads 챔피언 정보
     * @return 같은 챔피언 리스트로 반환
     */
    private List<ChampionPayload> findMaximumKeywordChampions(List<ChampionPayload> championPayloads) {
        return championPayloads.stream()
                .filter(champion -> champion.getKeywordCount() == verifyMaximumKeywordCount(championPayloads))
                .collect(Collectors.toList());
    }

    /**
     * 추천할 챔피언 1~3개 조회
     *
     * @param championPayloads 챔피언 정보
     * @return 챔피언 정보
     */
    private List<ChampionPayload> getChampions(List<ChampionPayload> championPayloads) {
        if (championPayloads.size() < MIN_CHAMPIONS_REQUIRED) {
            return championPayloads;
        }
        Collections.shuffle(championPayloads);
        return championPayloads.subList(FIRST_INDEX, MIN_CHAMPIONS_REQUIRED);
    }

    @Transactional(readOnly = true)
    public List<FindAllChampionResponse> findAll() {
        List<Champion> champions = championRepository.findAllByOrderByChampionNameKorAsc();
        return champions.stream()
                .map(FindAllChampionResponse::from)
                .collect(Collectors.toList());
    }

    /**
     * 챔피언 상세 조회
     *
     * @param championName 챔피언 이름
     * @return 챔피언 상세 정보
     */
    public FindByChampionSkinsResponse findByChampionSkins(String championName) {
        Empty championInfo = riotService.getDetailChampionInfo(championName);
        championInfo.getData().getChampionInfo().getSkins()
                .forEach(skin ->
                        skin.saveUrl(riotService.getChampionSkinUrl(championName, skin)));
        return FindByChampionSkinsResponse.from(championInfo.getData().getChampionInfo());
    }

    /**
     * 로테이션 챔피언 조회
     *
     * @return 로테이션 챔피언 이름 반환
     */
    public FindAllRotationChampionsResponse findAllRotationChampion() {
        RotationChampionPayload rotationChampionsKeys = riotService.getRotationChampions();
        List<Champion> rotationChampions = championRepository.findAll()
                .stream()
                .filter(champion ->
                        rotationChampionsKeys.getFreeChampionIds().contains(champion.getChampionRiotKey()))
                .toList();
        return FindAllRotationChampionsResponse.from(rotationChampions);
    }

    @Transactional
    @Scheduled(initialDelay = INITIAL_DELAY, fixedRate = Long.MAX_VALUE)
    public void saveChampionInfo() {
        List<Champion> champions = championRepository.findAll();
        Map<String, String> championInfos = riotService.getAllChampionInfo().getData().values().stream()
                .collect(Collectors.toMap(Datum::getId, Datum::getKey));
        champions.forEach(champion -> {
            champion.addChampionIconUrl(riotService.getChampionIconUrl(champion.getChampionNameEng()));
            // Riot Key 저장
            championInfos.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(champion.getChampionNameEng()))
                    .findFirst()
                    .ifPresent(entry -> champion.addChampionRiotKey(entry.getValue()));
        });
        championRepository.saveAll(champions);
    }

}
