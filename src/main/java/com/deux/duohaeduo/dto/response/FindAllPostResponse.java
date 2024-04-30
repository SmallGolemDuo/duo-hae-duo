package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.PostPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllPostResponse {

    private Page<PostPayload> postPayloads;

    public static FindAllPostResponse from(Page<PostPayload> postPayloads) {
        return FindAllPostResponse.builder()
                .postPayloads(postPayloads)
                .build();
    }

}
