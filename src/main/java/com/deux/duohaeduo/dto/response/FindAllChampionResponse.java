package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Champion;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindAllChampionResponse {

    private Long id;

    private final String championNameKor;

    private final String championNameEng;

    public static FindAllChampionResponse from(Champion champion) {
        return FindAllChampionResponse.builder()
                .id(champion.getId())
                .championNameKor(champion.getChampionNameKor())
                .championNameEng(champion.getChampionNameEng())
                .build();
    }

}
