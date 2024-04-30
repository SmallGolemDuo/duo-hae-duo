package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.PostPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostResponse {

    private PostPayload postPayload;

    public static CreatePostResponse from(PostPayload postPayload) {
        return CreatePostResponse.builder()
                .postPayload(postPayload)
                .build();
    }

}
