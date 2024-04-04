package com.deux.duohaeduo.dto.riot.matchInfo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Description {
    PRIMARY_STYLE, SUB_STYLE;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case PRIMARY_STYLE -> "primaryStyle";
            case SUB_STYLE -> "subStyle";
        };
    }

    @JsonCreator
    public static Description forValue(String value) throws IOException {
        if (value.equals("primaryStyle")) return PRIMARY_STYLE;
        if (value.equals("subStyle")) return SUB_STYLE;
        throw new IOException("Cannot deserialize Description");
    }

}
