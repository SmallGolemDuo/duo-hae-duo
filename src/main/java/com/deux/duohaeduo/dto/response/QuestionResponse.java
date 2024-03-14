package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.entity.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@RequiredArgsConstructor
public class QuestionResponse {

    private final long id;

    private final String question;

    public static QuestionResponse from(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .build();
    }

    public static List<QuestionResponse> fromList(List<Question> questions) {
        return questions.stream()
                .map(QuestionResponse::from)
                .collect(Collectors.toList());
    }

}
