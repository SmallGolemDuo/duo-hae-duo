package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.response.QuestionResponse;
import com.deux.duohaeduo.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public List<QuestionResponse> findAll() {
        return QuestionResponse.fromList(questionRepository.findAll());
    }

}
