package com.sparta.endrmseha_test.dto;

import com.sparta.endrmseha_test.entity.LikePost;
import lombok.Getter;

@Getter
public class LikePostResponseDto {

    private String username;
    private Long postId;
    public LikePostResponseDto(LikePost likePost) {
        this.username = likePost.getUser().getUsername();
        this.postId = likePost.getPost().getId();
    }
}