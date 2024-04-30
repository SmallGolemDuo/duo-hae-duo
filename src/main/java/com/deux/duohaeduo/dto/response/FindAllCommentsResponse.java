package com.deux.duohaeduo.dto.response;

import com.deux.duohaeduo.dto.CommentPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllCommentsResponse {

    private List<CommentPayload> commentPayloads;

    public static FindAllCommentsResponse from(List<CommentPayload> commentPayloads) {
        return FindAllCommentsResponse.builder()
                .commentPayloads(commentPayloads)
                .build();
    }

}
