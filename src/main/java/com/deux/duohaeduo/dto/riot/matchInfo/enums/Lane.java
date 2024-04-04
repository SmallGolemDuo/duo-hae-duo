package com.deux.duohaeduo.dto.riot.matchInfo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Lane {

    BOTTOM, MIDDLE, TOP, JUNGLE, NONE, UTILITY;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case BOTTOM -> "BOTTOM";
            case MIDDLE -> "MIDDLE";
            case TOP -> "TOP";
            case JUNGLE -> "JUNGLE";
            case NONE -> "NONE";
            case UTILITY -> "UTILITY";
        };
    }

    @JsonCreator
    public static Lane forValue(String value) throws IOException {
        if (value.equals("BOTTOM")) return BOTTOM;
        if (value.equals("MIDDLE")) return MIDDLE;
        if (value.equals("TOP")) return TOP;
        if (value.equals("JUNGLE")) return JUNGLE;
        if (value.equals("UTILITY")) return UTILITY;
        if (value.equals("NONE")) return NONE;
        throw new IOException("Cannot deserialize Lane");
    }

}
