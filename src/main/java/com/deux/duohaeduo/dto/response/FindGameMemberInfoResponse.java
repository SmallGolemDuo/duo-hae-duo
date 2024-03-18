package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.ConvertedRiotData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FindGameMemberInfoResponse {

    private ConvertedRiotData convertedRiotData;

}