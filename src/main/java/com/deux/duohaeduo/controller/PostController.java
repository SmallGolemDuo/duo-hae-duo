package com.deux.duohaeduo.controller;

import com.deux.duohaeduo.dto.request.CreateCommentRequest;
import com.deux.duohaeduo.dto.request.CreatePostRequest;
import com.deux.duohaeduo.dto.request.DeleteCommentRequest;
import com.deux.duohaeduo.dto.request.DeletePostRequest;
import com.deux.duohaeduo.dto.response.*;
import com.deux.duohaeduo.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lol/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public CreatePostResponse create(@Valid @RequestBody CreatePostRequest createPostRequest) {
        return postService.create(createPostRequest);
    }

    @GetMapping("/{postId}")
    public FindPostResponse findPost(@PathVariable(name = "postId") Long postId) {
        return postService.findByPost(postId);
    }

    @GetMapping
    public FindAllPostResponse findAll(@RequestParam(defaultValue = "0") int page) {
        return postService.findAll(page);
    }

    @PostMapping("/{postId}/likes")
    public FindPostResponse addLike(@PathVariable(name = "postId") Long postId) {
        return postService.addLike(postId);
    }

    @PostMapping("/{postId}/unlikes")
    public FindPostResponse removeLike(@PathVariable(name = "postId") Long postId) {
        return postService.removeLike(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "postId") Long postId,
                                          @Valid @RequestBody DeletePostRequest deletePostRequest) {
        return postService.delete(postId, deletePostRequest);
    }

    @PostMapping("/{postId}/comments")
    public CreateCommentResponse createComment(@PathVariable(name = "postId") Long postId,
                                               @Valid @RequestBody CreateCommentRequest createCommentRequest) {
        return postService.createComment(postId, createCommentRequest);
    }

    @GetMapping("/{postId}/comments")
    public FindAllCommentsResponse findAllComments(@PathVariable(name = "postId") Long postId) {
        return postService.findAllComments(postId);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable(name = "postId") Long postId,
                                                 @PathVariable(name = "commentId") Long commentId,
                                                 @Valid @RequestBody DeleteCommentRequest deleteCommentRequest) {
        return postService.deleteComment(postId, commentId, deleteCommentRequest);
    }

}
