package com.sparta.endrmseha_test.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostListResponseDto {
    private List<PostResponseDto> postsList;

    public PostListResponseDto(List<PostResponseDto> postsList) {
        this.postsList = postsList;
    }
}
