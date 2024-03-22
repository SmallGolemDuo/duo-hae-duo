package com.deux.duohaeduo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String question;

    @ElementCollection
    @Column(name = "answer_value")
    @MapKeyColumn(name = "answer_key")
    @CollectionTable(name = "recommendation_answers", joinColumns = @JoinColumn(name = "recommendation_id"))
    private final Map<String, String> answers = new HashMap<>();

}
