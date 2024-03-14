package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.ChampionPayload;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class ChampionResponse {

    private final List<ChampionPayload> championPayload;

    public static ChampionResponse from(List<ChampionPayload> championPayload) {
        return ChampionResponse.builder()
                .championPayload(championPayload)
                .build();
    }

}
