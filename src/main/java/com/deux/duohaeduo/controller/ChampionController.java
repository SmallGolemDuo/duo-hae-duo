package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.request.FindChampionRequest;
import com.deux.duohaeduo.dto.response.FindChampionResponse;
import com.deux.duohaeduo.service.ChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lol/champions")
public class ChampionController {

    private final ChampionService championService;

    @PostMapping
    public FindChampionResponse findByChampion(@RequestBody FindChampionRequest findChampionRequest) {
        return championService.findByChampion(findChampionRequest);
    }

}
