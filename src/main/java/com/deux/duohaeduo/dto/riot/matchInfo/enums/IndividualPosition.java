package com.deux.duohaeduo.dto.riot.matchInfo.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum IndividualPosition {

    INVALID, NONE, JUNGLE, TOP, MIDDLE, BOTTOM, UTILITY;

    @JsonValue
    public String toValue() {
        return switch (this) {
            case INVALID -> "Invalid";
            case BOTTOM -> "BOTTOM";
            case MIDDLE -> "MIDDLE";
            case TOP -> "TOP";
            case JUNGLE -> "JUNGLE";
            case NONE -> "NONE";
            case UTILITY -> "UTILITY";
        };
    }

    @JsonCreator
    public static IndividualPosition forValue(String value) throws IOException {
        if (value.equals("BOTTOM")) return BOTTOM;
        if (value.equals("MIDDLE")) return MIDDLE;
        if (value.equals("TOP")) return TOP;
        if (value.equals("JUNGLE")) return JUNGLE;
        if (value.equals("UTILITY")) return UTILITY;
        if (value.equals("NONE")) return NONE;
        if (value.equals("Invalid")) return INVALID;
        throw new IOException("Cannot deserialize IndividualPosition");
    }

}
