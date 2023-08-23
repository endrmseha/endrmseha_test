package com.sparta.endrmseha_test.service;

import com.sparta.endrmseha_test.dto.LikeCommentResponseDto;
import com.sparta.endrmseha_test.entity.Comment;
import com.sparta.endrmseha_test.entity.LikeComment;
import com.sparta.endrmseha_test.entity.User;
import com.sparta.endrmseha_test.repository.CommentRepository;
import com.sparta.endrmseha_test.repository.LikeCommentRepository;
import com.sparta.endrmseha_test.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeCommentService {

    private final LikeCommentRepository likeCommentRepository;
    private final CommentRepository commentRepository;
    private final MessageSource messageSource;
    public LikeCommentResponseDto save(UserDetailsImpl userDetails, Long id) {
        User user = userDetails.getUser();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "not.found.comment",
                                null,
                                "존재하지 않는 댓글입니다.",
                                Locale.getDefault()
                        )
                ));
        if (likeCommentRepository.findByUserAndComment(user, comment).isPresent())
            throw new IllegalArgumentException(
                    messageSource.getMessage(
                            "already.like.comment",
                            null,
                            "이미 좋아요한 댓글입니다.",
                            Locale.getDefault()
                    )
            );
        return new LikeCommentResponseDto(likeCommentRepository.save(new LikeComment(comment, userDetails.getUser())));
    }


    public Long delete(UserDetailsImpl userDetails, Long id) {
        User user = userDetails.getUser();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "not.found.comment",
                                null,
                                "존재하지 않는 댓글입니다.",
                                Locale.getDefault()
                        )
                ));
        LikeComment likeComment = likeCommentRepository.findByUserAndComment(user, comment)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "not.like.comment",
                                null,
                                "좋아요를 누르지 않은 댓글입니다.",
                                Locale.getDefault()
                        )
                ));
        likeCommentRepository.delete(likeComment);
        return id;
    }
}