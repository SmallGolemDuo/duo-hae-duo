package com.deux.duohaeduo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindChampionRequest {

    @NotNull
    private List<String> answers;

}
