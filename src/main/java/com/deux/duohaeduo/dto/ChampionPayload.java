package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.dto.request.ChampionRequest;
import com.deux.duohaeduo.entity.Champion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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

    public void verifyKeyword(ChampionRequest championRequest) {
        if (this.ultimateType.equals(championRequest.getUltimateType())) {
            keywordCount++;
        }
        if (this.difficulty.equals(championRequest.getDifficulty())) {
            keywordCount++;
        }
        if (this.skillDetails.equals(championRequest.getSkillDetails())) {
            keywordCount++;
        }
        if (this.attackType.equals(championRequest.getAttackType())) {
            keywordCount++;
        }
        if (this.damageType.equals(championRequest.getDamageType())) {
            keywordCount++;
        }
    }

}
