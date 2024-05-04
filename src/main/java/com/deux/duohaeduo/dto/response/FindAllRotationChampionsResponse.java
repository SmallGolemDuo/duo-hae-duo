package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Champion;
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

    private List<Champion> rotationChampions;

    public static FindAllRotationChampionsResponse from(List<Champion> rotationChampions) {
        return FindAllRotationChampionsResponse.builder()
                .rotationChampions(rotationChampions)
                .build();
    }

}
