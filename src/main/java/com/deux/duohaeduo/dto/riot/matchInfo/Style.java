package com.deux.duohaeduo.dto.riot.matchInfo;

import com.deux.duohaeduo.dto.riot.matchInfo.enums.Description;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Style {

    private Description description;
    private List<Selection> selections;
    private long style;

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description value) {
        this.description = value;
    }

    @JsonProperty("selections")
    public List<Selection> getSelections() {
        return selections;
    }

    @JsonProperty("selections")
    public void setSelections(List<Selection> value) {
        this.selections = value;
    }

    @JsonProperty("style")
    public long getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(long value) {
        this.style = value;
    }

}
