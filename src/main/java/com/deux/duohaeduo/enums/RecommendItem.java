package com.deux.duohaeduo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RecommendItem {

    ULTIMATE_TYPE(1),
    DIFFICULTY(2),
    SKILL_DETAILS(3),
    ATTACK_TYPE(4),
    DAMAGE_TYPE(5);

    private final int index;

}
