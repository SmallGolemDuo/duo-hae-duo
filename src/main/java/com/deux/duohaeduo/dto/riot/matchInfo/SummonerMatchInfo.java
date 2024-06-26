package com.deux.duohaeduo.dto.riot.matchInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummonerMatchInfo {

    private Metadata metadata;
    private Info info;

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata value) {
        this.metadata = value;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info value) {
        this.info = value;
    }

}
