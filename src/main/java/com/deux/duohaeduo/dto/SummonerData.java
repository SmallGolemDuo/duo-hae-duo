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
public class SummonerData {

    private Account account;
    private String summonerInfo;
    private List<String> gameMatch;

}