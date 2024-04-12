package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.request.FindGameUserInfoRequest;
import com.deux.duohaeduo.dto.response.FindGameMemberInfoResponse;
import com.deux.duohaeduo.service.SingleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lol/singles")
public class SingleController {

    private final SingleService singleService;

    // 소환사 단일 정보 조회
    @PostMapping()
    public FindGameMemberInfoResponse findGameMemberInfo(@Valid @RequestBody FindGameUserInfoRequest findGameUserInfoRequest) throws IOException, JSONException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        FindGameMemberInfoResponse findGameMemberInfoResponse = singleService.findGameUserInfo(findGameUserInfoRequest);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        double secDiffTime = (double) (afterTime - beforeTime) / 1000.0; //두 시간에 차 계산
        System.out.println("시간차이(m) : " + secDiffTime);
        return findGameMemberInfoResponse;
    }

}

