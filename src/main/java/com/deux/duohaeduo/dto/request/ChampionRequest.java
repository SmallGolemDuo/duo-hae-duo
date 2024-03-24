package com.deux.duohaeduo.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class ChampionRequest {

    private final List<String> recommendItems;

}
