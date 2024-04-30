package com.deux.duohaeduo.dto.request;

import com.deux.duohaeduo.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    @NotBlank(message = "작성자 닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(min = 4, message = "제목은 최소 4자 이상이어야 합니다.")
    private String title;

    @NotBlank(message = "패스워드를 입력해주세요.")
    @Size(min = 3, message = "패스워드는 최소 3자 이상이어야 합니다.")
    private String password;

    @URL
    @NotBlank(message = "영상 링크를 입력해주세요.")
    private String videoUrl;

    public Post toEntity(String encoderPassword, String thumbnailImageUrl) {
        return Post.builder()
                .nickname(this.nickname)
                .title(this.title)
                .password(encoderPassword)
                .videoUrl(this.videoUrl)
                .thumbnailImageUrl(thumbnailImageUrl)
                .build();
    }

}
