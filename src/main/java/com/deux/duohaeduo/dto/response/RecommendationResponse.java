package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Recommendation;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class RecommendationResponse {

    private final long id;

    private final String question;

    public static RecommendationResponse from(Recommendation recommendation) {
        return RecommendationResponse.builder()
                .id(recommendation.getId())
                .question(recommendation.getQuestion())
                .build();
    }

    public static List<RecommendationResponse> fromList(List<Recommendation> recommendations) {
        return recommendations.stream()
                .map(RecommendationResponse::from)
                .collect(Collectors.toList());
    }

}
