package com.deux.duohaeduo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AnswerResponse {

    private final long id;

    private final int questionNo;

    private final String answer;

}
