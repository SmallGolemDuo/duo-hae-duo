package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Image {

    @JsonProperty("full")
    private String full;

    @JsonProperty("sprite")
    private String sprite;

    @JsonProperty("group")
    private String group;

    @JsonProperty("x")
    private long x;

    @JsonProperty("y")
    private long y;

    @JsonProperty("w")
    private long w;

    @JsonProperty("h")
    private long h;

}
