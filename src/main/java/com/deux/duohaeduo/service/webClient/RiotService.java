package com.deux.duohaeduo.service.webClient;

import com.deux.duohaeduo.dto.Account;
import com.deux.duohaeduo.dto.FindGameMemberInfo;
import com.deux.duohaeduo.dto.SummonerData;
import com.deux.duohaeduo.dto.riot.champion.Empty;
import com.deux.duohaeduo.dto.riot.champion.Skin;
import com.deux.duohaeduo.dto.riot.matchInfo.Converter;
import com.deux.duohaeduo.dto.riot.matchInfo.SummonerMatchInfo;
import com.deux.duohaeduo.excpetion.riotApi.AccountNotFoundException;
import com.deux.duohaeduo.excpetion.riotApi.GameDetailedMatchNotFoundException;
import com.deux.duohaeduo.excpetion.riotApi.GameMatchNotFoundException;
import com.deux.duohaeduo.excpetion.riotApi.GameUserInfoNotFoundException;
import com.deux.duohaeduo.service.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RiotService {

    private static final String RIOT_VERSION = "14.7.1";

    @Value("${riot.api_key_j}")
    private String riotApiKeyJ;

    @Value("${riot.api_key_w}")
    private String riotApiKeyW;

    private final CacheService cacheService;

    private final WebClient webClient;

    public RiotService(CacheService cacheService) {
        this.webClient = WebClient.create();
        this.cacheService = cacheService;
    }

    // 라이엇 API_KEY 2개를 번갈아 가면서 사용
    // 소환사 정보 + 게임 상세정보 합병
    @Transactional
    public FindGameMemberInfo findRiotGameMemberInfo(String nickname, String tag, Long gameMemberCount, Long matchCount) throws IOException {
        String riotApiKey;
        if (gameMemberCount % 2 == 0) {
            riotApiKey = riotApiKeyW;
        } else {
            riotApiKey = riotApiKeyJ;
        }

        SummonerData summonerData = findSummonerData(nickname, tag, riotApiKey);
        List<SummonerMatchInfo> matchInfoList = findMatchDetails(summonerData.getGameMatch(), riotApiKey, matchCount); // 최근 게임들 상세정보 조회

        return new FindGameMemberInfo(summonerData.getSummonerInfo(), matchInfoList);
    }

    // PUUID, 소환사 정보, 게임들 조회
    @Transactional
    public SummonerData findSummonerData(String nickname, String tag, String riotApiKey) {
        String summonerDataCacheKey = nickname + "#" + tag;

        SummonerData summonerDataCachedResult = cacheService.findRiotGameSummonerDataFromCache(summonerDataCacheKey);
        if (summonerDataCachedResult != null) {
            return summonerDataCachedResult;
        }

        Account account = findPuuid(nickname, tag, riotApiKey);
        String summonerInfo = findSummonerInfo(account, riotApiKey);
        List<String> gameMatch = findMatches(account, riotApiKey);

        SummonerData summonerData = SummonerData.builder()
                .account(account)
                .summonerInfo(summonerInfo)
                .gameMatch(gameMatch)
                .build();

        cacheService.summonerDataCacheResult(summonerDataCacheKey, summonerData);
        return summonerData;
    }

    // 닉네임과 태그를 통해서 PUUID(소환사 id) 찾기
    public Account findPuuid(String nickname, String tag, String riotApiKey) {
        Account account = webClient
                .get()
                .uri("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/" + nickname + "/" + tag + "?api_key=" + riotApiKey)
                .retrieve()
                .bodyToMono(Account.class)
                .block();
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    // 소환사 정보 찾기
    public String findSummonerInfo(Account account, String riotApiKey) {
        String puuid = account.getPuuid();
        String summonerInfo = webClient
                .get()
                .uri("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/{puuid}", uriBuilder ->
                        uriBuilder.queryParam("api_key", riotApiKey)
                                .build(puuid)
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (summonerInfo == null) {
            throw new GameUserInfoNotFoundException();
        }

        return summonerInfo;
    }

    // 게임들 id 조회
    public List<String> findMatches(Account account, String riotApiKey) {
        List<String> gameMatch = webClient
                .get()
                .uri("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/" + account.getPuuid() + "/ids?start=0&count=20&api_key=" + riotApiKey)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {
                })
                .block();

        if (gameMatch == null) {
            throw new GameMatchNotFoundException();
        }

        return gameMatch;
    }


    // 게임 id별 게임 상세정보 조회
    public List<SummonerMatchInfo> findMatchDetails(List<String> gameMatch, String riotApiKey, Long matchCount) throws IOException {
        List<SummonerMatchInfo> matchInfoList = new ArrayList<>();

        for (int i = 0; i < matchCount; i++) {
            String matchInfoCacheKey = gameMatch.get(i);
            SummonerMatchInfo matchInfoCacheResult = cacheService.findRiotGameMatchInfosFromCache(matchInfoCacheKey);

            if (matchInfoCacheResult != null) {
                matchInfoList.add(matchInfoCacheResult);
                continue;
            }

            String gameMatchDetailed = webClient
                    .get()
                    .uri("https://asia.api.riotgames.com/lol/match/v5/matches/" + gameMatch.get(i) + "?api_key=" + riotApiKey)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            if (gameMatchDetailed != null) {
                SummonerMatchInfo matchInfo = Converter.fromJsonString(gameMatchDetailed);
                matchInfoList.add(matchInfo);
            }

            cacheService.matchInfosCacheResult(matchInfoCacheKey, Converter.fromJsonString(gameMatchDetailed));
        }

        if (matchInfoList.size() == 0) {
            throw new GameDetailedMatchNotFoundException();
        }

        return matchInfoList;
    }

    public Empty getChampionInfo(String championName) {
        try {
            Empty empty = webClient.get()
                    .uri("https://ddragon.leagueoflegends.com/cdn/" + RIOT_VERSION + "/data/ko_KR/champion/" + championName + ".json")
                    .retrieve()
                    .bodyToMono(Empty.class)
                    .block();
            if (empty == null) {
                throw new RuntimeException("라이엇 데이터가 없습니다.");
            }
            return empty;
        } catch (WebClientResponseException.NotFound e) {
            throw new RuntimeException("올바른 URI 가 아닙니다.", e);
        } catch (Exception e) {
            throw new RuntimeException("알 수 없는 오류가 발생했습니다.", e);
        }
    }

    public String getChampionSkinUrl(String championName, Skin skin) {
        return "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + championName + "_" + skin.getNum() + ".jpg";
    }

    public String getChampionIconUrl(String championName) {
        return "https://ddragon.leagueoflegends.com/cdn/" + RIOT_VERSION + "/img/champion/" + championName + ".png";
    }

}

