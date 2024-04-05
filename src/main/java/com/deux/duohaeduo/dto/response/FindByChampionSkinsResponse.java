package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.riot.champion.ChampionInfo;
import com.deux.duohaeduo.dto.riot.champion.Skin;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class FindByChampionSkinsResponse {

    private final String key;

    private final String championNameKor;

    private final String championNameEng;

    private final List<Skin> skins;

    public static FindByChampionSkinsResponse from(ChampionInfo championInfo) {
        return FindByChampionSkinsResponse.builder()
                .key(championInfo.getKey())
                .championNameKor(championInfo.getName())
                .championNameEng(championInfo.getId())
                .skins(championInfo.getSkins())
                .build();
    }

}
