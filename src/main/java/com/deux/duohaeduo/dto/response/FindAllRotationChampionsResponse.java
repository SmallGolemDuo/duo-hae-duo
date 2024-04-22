package com.deux.duohaeduo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllRotationChampionsResponse {

    private List<String> rotationChampionNames;

    public static FindAllRotationChampionsResponse from(List<String> rotationChampionNames) {
        return FindAllRotationChampionsResponse.builder()
                .rotationChampionNames(rotationChampionNames)
                .build();
    }
}
