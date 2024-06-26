package com.deux.duohaeduo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String championNameKor;

    private final String championNameEng;

    private String championType;

    private String difficulty;

    private String damageType;

    private String attackType;

    private String ultimateType;

    private String skillDetails;

    private String position;

    @URL
    private String championIconUrl;

    private String championRiotKey;

    public void addChampionIconUrl(String championIconUrl) {
        this.championIconUrl = championIconUrl;
    }

    public void addChampionRiotKey(String championRiotKey) {
        this.championRiotKey = championRiotKey;
    }

}
