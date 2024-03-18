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
public class SearchSummonerInfo {

    // 검색 된 소환사 정보
    private String championName;
    private List<Long> items;
    private Long kills;
    private Long deaths;
    private Long assists;
    private String spell1;
    private String spell2;
    private boolean win;

}