package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.response.RecommendationResponse;
import com.deux.duohaeduo.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    @Transactional(readOnly = true)
    public List<RecommendationResponse> findAll() {
        return RecommendationResponse.fromList(recommendationRepository.findAll());
    }

}
