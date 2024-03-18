package com.deux.duohaeduo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindGameUserInfoRequest {

    @NotNull
    private String gameNickname;

}