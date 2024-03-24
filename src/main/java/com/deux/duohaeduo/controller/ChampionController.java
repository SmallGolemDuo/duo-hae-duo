package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.request.ChampionRequest;
import com.deux.duohaeduo.dto.response.ChampionResponse;
import com.deux.duohaeduo.service.ChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lol/champions")
public class ChampionController {

    private final ChampionService championService;

    @PostMapping
    public ChampionResponse findByChampion(@RequestBody ChampionRequest championRequest) {
        return championService.findByChampion(championRequest);
    }

}
