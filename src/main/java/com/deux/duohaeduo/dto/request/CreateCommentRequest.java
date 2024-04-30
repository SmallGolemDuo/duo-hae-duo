package com.deux.duohaeduo.dto.request;

import com.deux.duohaeduo.entity.Comment;
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
public class CreateCommentRequest {

    @NotBlank(message = "작성자 닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "패스워드를 입력해주세요.")
    @Size(min = 3, message = "패스워드는 최소 3자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "댓글 내용을 입력해주세요.")
    private String content;

    public Comment toEntity(String password) {
        return Comment.builder()
                .nickname(this.nickname)
                .password(password)
                .content(this.content)
                .build();
    }

}
