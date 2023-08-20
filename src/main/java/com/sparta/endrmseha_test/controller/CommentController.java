package com.sparta.endrmseha_test.controller;

import com.sparta.endrmseha_test.dto.ApiResponseDto;
import com.sparta.endrmseha_test.dto.CommentRequestDto;
import com.sparta.endrmseha_test.dto.CommentResponseDto;
import com.sparta.endrmseha_test.dto.CommentUpdateRequestDto;
import com.sparta.endrmseha_test.security.UserDetailsImpl;
import com.sparta.endrmseha_test.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.RejectedExecutionException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<?> save(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentRequestDto requestDto){
        return ResponseEntity.ok(commentService.save(userDetails, requestDto));

    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CommentUpdateRequestDto requestDto){
        return ResponseEntity.ok(commentService.update(id, userDetails, requestDto));
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.delete(id, userDetails);
        return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 성공");
    }
}