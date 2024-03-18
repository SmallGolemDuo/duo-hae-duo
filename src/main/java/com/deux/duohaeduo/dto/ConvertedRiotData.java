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
public class ConvertedRiotData {

    // 프로필 데이터
    private String summonerName;
    private String summonerLevel;
    private String profileIconId;

    // 매치 데이터
    private List<MatchInfo> matchInfos;

}