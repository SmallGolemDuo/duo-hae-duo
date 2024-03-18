package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.*;
import com.deux.duohaeduo.dto.matchInfo.Participant;
import com.deux.duohaeduo.dto.matchInfo.SummonerMatchInfo;
import com.deux.duohaeduo.enums.SummonerSpells;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class GroupService {


    // 날짜, 게임 모드, 게임 시간, 검색자아이템, 게임참가사람들 닉네임과 챔피언 승패여부, 킬뎃어시, 스팰
    @Transactional
    public ConvertedRiotData convertRiotSummonerInfo(FindGameMemberInfo findGameMemberInfo) throws JSONException {
        JSONObject jsonUserInfo = new JSONObject(findGameMemberInfo.getUserInfo());

        SearchSummonerInfo searchSummonerInfo = null;

        // 프로필 데이터
        String name = jsonUserInfo.getString("name"); // 검색 된 소환사명
        String summonerLevel = jsonUserInfo.getString("summonerLevel"); // 검색 된 소환사레벨
        String profileIconId = jsonUserInfo.getString("profileIconId"); // 검색 된 소환사 프로필 id

        List<MatchInfo> matchInfos = new ArrayList<>();

        // 매치 데이터
        for (SummonerMatchInfo summonerMatchInfo : findGameMemberInfo.getMatchInfoList()) { // 1게임
            List<MatchParticipantInfo> matchParticipantInfos = new ArrayList<>();

            Date date = new Date(summonerMatchInfo.getInfo().getGameCreation()); // 게임 만든 날짜
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
            String gameCreatedDate = simpleDateFormat.format(date);

            String gameMode = summonerMatchInfo.getInfo().getGameMode(); // 게임 모드
            String gameTotalTime = String.valueOf(Math.floor(summonerMatchInfo.getInfo().getGameDuration() / 60f)); // 게임 진행 시간

            for (Participant participant : summonerMatchInfo.getInfo().getParticipants()) { // 10명

                String championName = participant.getChampionName(); // 챔피언 이름
                String participantName = participant.getRiotIDGameName(); // 소환사명
                boolean isWin = participant.getWin(); // 팀을 나누기 위한 승패여부

                if (name.equals(participant.getRiotIDGameName())) { // 검색 된 소환사 기준 찾기

                    String searchChampionName = participant.getChampionName();

                    List<Long> items = List.of( // 아이템 아이템이 0이면 없는 것
                            participant.getItem0(),
                            participant.getItem1(),
                            participant.getItem2(),
                            participant.getItem3(),
                            participant.getItem4(),
                            participant.getItem5(),
                            participant.getItem6()
                    );

                    Long kills = participant.getKills(); // 킬
                    Long deaths = participant.getDeaths(); // 데스
                    Long assists = participant.getAssists(); // 어시

                    String spell1 = SummonerSpells.findByKey(participant.getSummoner1ID()); // 스펠1
                    String spell2 = SummonerSpells.findByKey(participant.getSummoner2ID()); // 스펠2

                    boolean searchSummonerIsWin = participant.getWin(); // 검색 된 소환사 승패 여부 // 이겼으면 파란색, 졌으면 빨간색

                    searchSummonerInfo = SearchSummonerInfo.builder()
                            .championName(searchChampionName)
                            .items(items)
                            .kills(kills)
                            .deaths(deaths)
                            .assists(assists)
                            .spell1(spell1)
                            .spell2(spell2)
                            .win(searchSummonerIsWin)
                            .build();
                }
                matchParticipantInfos.add(MatchParticipantInfo.builder()
                        .participantName(participantName)
                        .championName(championName)
                        .win(isWin)
                        .build());

            }
            matchInfos.add(MatchInfo.builder()
                    .gameCreatedDate(gameCreatedDate)
                    .gameMode(gameMode)
                    .gameTotalTime(gameTotalTime)
                    .matchParticipantInfos(matchParticipantInfos)
                    .searchSummonerInfo(searchSummonerInfo)
                    .build());

        }
        return ConvertedRiotData.builder()
                .summonerName(name)
                .summonerLevel(summonerLevel)
                .profileIconId(profileIconId)
                .matchInfos(matchInfos)
                .build();
    }

}
