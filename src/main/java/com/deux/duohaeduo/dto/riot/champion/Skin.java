package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Skin {

    @JsonProperty("id")
    private String id;

    @JsonProperty("num")
    private long num;

    @JsonProperty("name")
    private String name;

    @JsonProperty("chromas")
    private boolean chromas;

    @JsonProperty("url")
    private String url;

    public void saveUrl(String skinUrl) {
        this.url = skinUrl;
    }

}
