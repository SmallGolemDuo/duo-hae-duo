package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.response.QuestionResponse;
import com.deux.duohaeduo.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionResponse> findAll() {
        return questionService.findAll();
    }

}
