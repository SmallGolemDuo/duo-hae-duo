package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.ChampionPayload;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindChampionResponse {

    private final List<ChampionPayload> championPayloads;

    public static FindChampionResponse from(List<ChampionPayload> championPayloads) {
        return FindChampionResponse.builder()
                .championPayloads(championPayloads)
                .build();
    }

}
