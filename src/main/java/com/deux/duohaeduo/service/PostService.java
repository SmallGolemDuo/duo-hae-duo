package com.deux.duohaeduo.service;

import com.deux.duohaeduo.dto.CommentPayload;
import com.deux.duohaeduo.dto.PostPayload;
import com.deux.duohaeduo.dto.request.CreateCommentRequest;
import com.deux.duohaeduo.dto.request.CreatePostRequest;
import com.deux.duohaeduo.dto.request.DeleteCommentRequest;
import com.deux.duohaeduo.dto.request.DeletePostRequest;
import com.deux.duohaeduo.dto.response.*;
import com.deux.duohaeduo.entity.Comment;
import com.deux.duohaeduo.entity.Post;
import com.deux.duohaeduo.excpetion.post.CommentNotFoundException;
import com.deux.duohaeduo.excpetion.post.PostNotFoundException;
import com.deux.duohaeduo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private static final int DEFAULT_NUMBER_OF_POSTS = 10;

    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CreatePostResponse create(CreatePostRequest createPostRequest) {
        String videoId = getVideoId(createPostRequest.getVideoUrl());
        String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/0.jpg";
        Post post = createPostRequest.toEntity(passwordEncoder.encode(createPostRequest.getPassword()), thumbnailUrl);
        return CreatePostResponse.from(PostPayload.from(postRepository.save(post)));
    }

    private String getVideoId(String videoUrl) {
        Pattern pattern = Pattern.compile("(?<=v=)[a-zA-Z0-9_-]+(?=&|$)");
        Matcher matcher = pattern.matcher(videoUrl);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new IllegalArgumentException("잘못된 동영상 링크입니다.");
        }
    }

    @Transactional(readOnly = true)
    public FindPostResponse findByPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        return FindPostResponse.from(PostPayload.from(post));
    }

    @Transactional(readOnly = true)
    public FindAllPostResponse findAll(int page) {
        Pageable pageable = PageRequest.of(page, DEFAULT_NUMBER_OF_POSTS);
        return FindAllPostResponse.from(postRepository.findAll(pageable)
                .map(PostPayload::from));
    }

    @Transactional
    public FindPostResponse addLike(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        post.addLike();
        return FindPostResponse.from(PostPayload.from(postRepository.save(post)));
    }

    @Transactional
    public FindPostResponse removeLike(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        post.removeLike();
        return FindPostResponse.from(PostPayload.from(postRepository.save(post)));
    }

    @Transactional
    public ResponseEntity<Boolean> delete(Long postId, DeletePostRequest deletePostRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        if (!passwordEncoder.matches(deletePostRequest.getPassword(), post.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        postRepository.delete(post);
        return ResponseEntity.ok(true);
    }

    @Transactional
    public CreateCommentResponse createComment(Long postId, CreateCommentRequest createCommentRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        Comment comment = createCommentRequest.toEntity(passwordEncoder.encode(createCommentRequest.getPassword()));
        post.addComments(comment);
        postRepository.save(post);
        return CreateCommentResponse.from(CommentPayload.from(comment));
    }

    @Transactional(readOnly = true)
    public FindAllCommentsResponse findAllComments(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        return FindAllCommentsResponse.from(post.getComments().stream()
                .map(CommentPayload::from)
                .collect(Collectors.toList()));
    }

    @Transactional
    public ResponseEntity<Boolean> deleteComment(Long postId, Long commentId, DeleteCommentRequest deleteCommentRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        Comment comment = post.findByCommentId(commentId);
        if (comment == null) {
            throw new CommentNotFoundException();
        }
        if (!passwordEncoder.matches(deleteCommentRequest.getPassword(), comment.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        post.deleteComment(commentId);
        return ResponseEntity.ok(true);
    }

}
