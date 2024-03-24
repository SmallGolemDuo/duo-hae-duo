package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.response.RecommendationResponse;
import com.deux.duohaeduo.entity.Recommendation;
import com.deux.duohaeduo.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Transactional(readOnly = true)
    public List<RecommendationResponse> findAll() {
        List<Recommendation> recommendations = recommendationRepository.findAll();
        recommendations.forEach(recommendation -> {
            Hibernate.initialize(recommendation.getAnswers());
        });
        return recommendations.stream()
                .map(RecommendationResponse::from)
                .collect(Collectors.toList());
    }

}
