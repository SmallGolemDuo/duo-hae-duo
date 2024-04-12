package com.deux.duohaeduo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MatchInfo {

    // 매치 데이터
    private String gameCreatedDate;
    private String gameMode;
    private String gameTotalTime;
    private List<MatchParticipantInfo> matchParticipantInfos;

    // 검색 된 소환사
    private SearchSummonerInfo searchSummonerInfo;

}
