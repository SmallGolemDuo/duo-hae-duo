package com.deux.duohaeduo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String championName;

    private String championType;

    private String difficulty;

    private String damageType;

    private String attackType;

    private String ultimateType;

    private String skillDetails;

    private String position;

}
