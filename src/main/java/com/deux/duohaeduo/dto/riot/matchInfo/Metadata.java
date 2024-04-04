package com.deux.duohaeduo.dto.riot.matchInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Metadata {

    private String dataVersion;
    private String matchID;
    private List<String> participants;

    @JsonProperty("dataVersion")
    public String getDataVersion() {
        return dataVersion;
    }

    @JsonProperty("dataVersion")
    public void setDataVersion(String value) {
        this.dataVersion = value;
    }

    @JsonProperty("matchId")
    public String getMatchID() {
        return matchID;
    }

    @JsonProperty("matchId")
    public void setMatchID(String value) {
        this.matchID = value;
    }

    @JsonProperty("participants")
    public List<String> getParticipants() {
        return participants;
    }

    @JsonProperty("participants")
    public void setParticipants(List<String> value) {
        this.participants = value;
    }

}
