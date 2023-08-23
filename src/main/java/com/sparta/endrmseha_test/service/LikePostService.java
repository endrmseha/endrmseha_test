package com.sparta.endrmseha_test.service;

import com.sparta.endrmseha_test.dto.LikePostResponseDto;
import com.sparta.endrmseha_test.entity.LikePost;
import com.sparta.endrmseha_test.entity.Post;
import com.sparta.endrmseha_test.entity.User;
import com.sparta.endrmseha_test.repository.LikePostRepository;
import com.sparta.endrmseha_test.repository.PostRepository;
import com.sparta.endrmseha_test.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional
public class LikePostService {

    private final LikePostRepository likePostRepository;
    private final PostRepository postRepository;
    private final MessageSource messageSource;
    public LikePostResponseDto save(UserDetailsImpl userDetails, Long id) {
        User user = userDetails.getUser();
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "not.found.post",
                                null,
                                "존재하지 않는 게시글입니다.",
                                Locale.getDefault()
                        )
                ));
        if (likePostRepository.findByUserAndPost(user, post).isPresent())
            throw new IllegalArgumentException(
                    messageSource.getMessage(
                            "already.like.post",
                            null,
                            "이미 좋아요한 게시글입니다.",
                            Locale.getDefault()
                    )
            );
        return new LikePostResponseDto(likePostRepository.save(new LikePost(post, userDetails.getUser())));
    }

    public Long delete(UserDetailsImpl userDetails, Long id) {
        User user = userDetails.getUser();
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "not.found.post",
                                null,
                                "존재하지 않는 게시글입니다.",
                                Locale.getDefault()
                        )
                ));
        LikePost likePost = likePostRepository.findByUserAndPost(user, post)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "not.like.post",
                                null,
                                "좋아요를 누르지 않은 게시글입니다.",
                                Locale.getDefault()
                        )
                ));
        likePostRepository.delete(likePost);
        return id;
    }
}