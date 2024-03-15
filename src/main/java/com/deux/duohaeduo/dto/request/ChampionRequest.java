package com.deux.duohaeduo.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ChampionRequest {

    private final String difficulty;

    private final String damageType;

    private final String attackType;

    private final String championType;

    private final String ultimateType;

    private final String skillDetails;

}
