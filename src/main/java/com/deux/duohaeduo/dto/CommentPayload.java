package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CommentPayload {

    private Long id;

    private String nickname;

    private String content;

    private LocalDateTime createdAt;

    private Long postId;

    public static CommentPayload from(Comment comment) {
        return CommentPayload.builder()
                .id(comment.getId())
                .nickname(comment.getNickname())
                .content(comment.getContent())
                .createdAt(LocalDateTime.now())
                .postId(comment.getPost().getId())
                .build();
    }

}
