package com.sparta.endrmseha_test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CommentRequestDto {
    private Long postId;
    private Long parentId;
    private String content;
}
