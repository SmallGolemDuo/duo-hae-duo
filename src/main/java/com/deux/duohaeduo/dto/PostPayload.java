package com.deux.duohaeduo.dto;

import com.deux.duohaeduo.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class PostPayload {

    private Long id;

    private String nickname;

    private String title;

    private long likeCount;

    private String videoUrl;

    private String thumbnailImageUrl;

    private LocalDateTime createdAt;

    private List<CommentPayload> commentPayloads;

    public static PostPayload from(Post post) {
        return PostPayload.builder()
                .id(post.getId())
                .nickname(post.getNickname())
                .title(post.getTitle())
                .likeCount(post.getLikeCount())
                .videoUrl(post.getVideoUrl())
                .thumbnailImageUrl(post.getThumbnailImageUrl())
                .createdAt(post.getCreatedAt())
                .commentPayloads(post.getComments().stream()
                        .map(CommentPayload::from)
                        .collect(Collectors.toList()))
                .build();
    }

}
