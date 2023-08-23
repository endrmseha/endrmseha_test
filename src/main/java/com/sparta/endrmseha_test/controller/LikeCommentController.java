package com.sparta.endrmseha_test.controller;

import com.sparta.endrmseha_test.dto.LikeCommentResponseDto;
import com.sparta.endrmseha_test.security.UserDetailsImpl;
import com.sparta.endrmseha_test.service.LikeCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeCommentController {
    private final LikeCommentService likeCommentService;

    @PostMapping("/like/comment/{id}")
    public ResponseEntity<LikeCommentResponseDto> like(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id){
        return ResponseEntity.ok(likeCommentService.save(userDetails, id));
    }

    @DeleteMapping("/like/comment/{id}")
    public ResponseEntity<Long> dislike(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id){
        return ResponseEntity.ok(likeCommentService.delete(userDetails, id));
    }
}