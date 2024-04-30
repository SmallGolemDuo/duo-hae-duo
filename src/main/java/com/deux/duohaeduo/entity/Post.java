package com.deux.duohaeduo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String title;

    private String password;

    private long likeCount;

    @URL
    private String videoUrl;

    @URL
    private String thumbnailImageUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "post",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public void addLike() {
        this.likeCount++;
    }

    public void removeLike() {
        this.likeCount--;
    }

    public void addComments(Comment comment) {
        comment.addPost(this);
        this.comments.add(comment);
    }

    public Comment findByCommentId(Long commentId) {
        return this.comments.stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst()
                .orElse(null);
    }

    public void deleteComment(Long commentId) {
        this.comments.removeIf(comment -> comment.getId().equals(commentId));
    }

}
