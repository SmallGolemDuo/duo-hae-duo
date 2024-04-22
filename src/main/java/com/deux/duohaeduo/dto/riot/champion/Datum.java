package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
public class Datum {

    @JsonProperty("version")
    private String version;

    @JsonProperty("id")
    private String id;

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("blurb")
    private String blurb;

    @JsonProperty("info")
    private Info info;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("partype")
    private String partype;

    @JsonProperty("stats")
    private Map<String, Double> stats;
}
