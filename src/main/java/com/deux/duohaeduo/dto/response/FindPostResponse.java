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
public class FindPostResponse {

    private PostPayload postPayload;

    public static FindPostResponse from(PostPayload postPayload) {
        return FindPostResponse.builder()
                .postPayload(postPayload)
                .build();
    }

}
