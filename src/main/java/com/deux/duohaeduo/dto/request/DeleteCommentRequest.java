package com.deux.duohaeduo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCommentRequest {

    @NotBlank(message = "패스워드를 입력해주세요.")
    @Size(min = 3, message = "패스워드는 최소 3자 이상이어야 합니다.")
    private String password;

}
