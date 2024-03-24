package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Recommendation;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class RecommendationResponse {

    private final long id;

    private final String question;

    private final Map<String, String> answers;

    public static RecommendationResponse from(Recommendation recommendation) {
        return RecommendationResponse.builder()
                .id(recommendation.getId())
                .question(recommendation.getQuestion())
                .answers(recommendation.getAnswers())
                .build();
    }

}
