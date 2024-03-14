package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.response.AnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/{questionId}")
    public AnswerResponse findById(@PathVariable("questionId") Long questionId) {
        return answerService.findById(questionId);
    }

}
