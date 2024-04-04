package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Info {

    @JsonProperty("attack")
    private long attack;

    @JsonProperty("defense")
    private long defense;

    @JsonProperty("magic")
    private long magic;

    @JsonProperty("difficulty")
    private long difficulty;

}
