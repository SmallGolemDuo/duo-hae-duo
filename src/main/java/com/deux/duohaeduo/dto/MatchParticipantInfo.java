package com.deux.duohaeduo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MatchParticipantInfo {

    private String championName;
    private String participantName;
    private boolean win;

}