package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.dto.riot.matchInfo.SummonerMatchInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FindGameMemberInfo {

    private String userInfo;
    private List<SummonerMatchInfo> matchInfoList;

}