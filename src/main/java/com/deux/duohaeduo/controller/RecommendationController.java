package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.response.RecommendationResponse;
import com.deux.duohaeduo.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lol/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService questionService;

    @GetMapping
    public List<RecommendationResponse> findAll() {
        return questionService.findAll();
    }

}
