package com.deux.duohaeduo.dto.riot.champion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ChampionInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("skins")
    private List<Skin> skins;

    @JsonProperty("lore")
    private String lore;

    @JsonProperty("blurb")
    private String blurb;

    @JsonProperty("allytips")
    private List<String> allytips;

    @JsonProperty("enemytips")
    private List<String> enemytips;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("partype")
    private String partype;

    @JsonProperty("info")
    private Info info;

    @JsonProperty("spells")
    private List<Spell> spells;

    @JsonProperty("passive")
    private Passive passive;

}
