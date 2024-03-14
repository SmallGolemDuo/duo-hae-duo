package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.response.RecommendationResponse;
import com.deux.duohaeduo.repository.ChampionRepository;
import com.deux.duohaeduo.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChampionService {

    private final ChampionRepository championRepository;
    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public List<RecommendationResponse> findAll() {
        return RecommendationResponse.fromList(questionRepository.findAll());
    }

}
