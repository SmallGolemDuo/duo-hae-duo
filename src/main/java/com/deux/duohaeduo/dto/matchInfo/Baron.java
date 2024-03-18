package com.deux.duohaeduo.dto.matchInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Baron {
    private boolean first;
    private long kills;

    @JsonProperty("first")
    public boolean getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(boolean value) {
        this.first = value;
    }

    @JsonProperty("kills")
    public long getKills() {
        return kills;
    }

    @JsonProperty("kills")
    public void setKills(long value) {
        this.kills = value;
    }

}
