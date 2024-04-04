package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Spell {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tooltip")
    private String tooltip;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("resource")
    private String resource;

}
