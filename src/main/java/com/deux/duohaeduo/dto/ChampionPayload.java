package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.entity.Champion;
import com.deux.duohaeduo.enums.RecommendItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ChampionPayload {

    private Long id;

    private final String championNameKor;

    private final String championNameEng;

    private String championType;

    private String ultimateType;

    private String difficulty;

    private String skillDetails;

    private String attackType;

    private String damageType;

    private String position;

    private int keywordCount;

    public static ChampionPayload from(Champion champion) {
        return ChampionPayload.builder()
                .id(champion.getId())
                .championNameKor(champion.getChampionNameKor())
                .championNameEng(champion.getChampionNameEng())
                .championType(champion.getChampionType())
                .difficulty(champion.getDifficulty())
                .damageType(champion.getDamageType())
                .attackType(champion.getAttackType())
                .ultimateType(champion.getUltimateType())
                .skillDetails(champion.getSkillDetails())
                .position(champion.getPosition())
                .build();
    }

    public void verifyKeyword(List<String> recommendItems) {
        if (this.ultimateType.equals(recommendItems.get(RecommendItem.ULTIMATE_TYPE.getIndex()))) {
            keywordCount++;
        }
        if (this.difficulty.equals(recommendItems.get(RecommendItem.DIFFICULTY.getIndex()))) {
            keywordCount++;
        }
        if (this.skillDetails.equals(recommendItems.get(RecommendItem.SKILL_DETAILS.getIndex()))) {
            keywordCount++;
        }
        if (this.attackType.equals(recommendItems.get(RecommendItem.ATTACK_TYPE.getIndex()))) {
            keywordCount++;
        }
        if (this.damageType.equals(recommendItems.get(RecommendItem.DAMAGE_TYPE.getIndex()))) {
            keywordCount++;
        }
    }

}
