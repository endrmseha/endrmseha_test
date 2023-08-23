package com.sparta.endrmseha_test.controller;

import com.sparta.endrmseha_test.dto.LikePostResponseDto;
import com.sparta.endrmseha_test.security.UserDetailsImpl;
import com.sparta.endrmseha_test.service.LikePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikePostController {

    private final LikePostService likePostService;

    @PostMapping("/like/posts/{id}")
    public ResponseEntity<LikePostResponseDto> like(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id){
        LikePostResponseDto responseDto = likePostService.save(userDetails, id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/like/posts/{id}")
    public ResponseEntity<Long> dislike(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id){
        return ResponseEntity.ok(likePostService.delete(userDetails, id));
    }
}