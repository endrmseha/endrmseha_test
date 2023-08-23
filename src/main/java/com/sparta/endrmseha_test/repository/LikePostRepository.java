package com.sparta.endrmseha_test.repository;

import com.sparta.endrmseha_test.entity.LikePost;
import com.sparta.endrmseha_test.entity.Post;
import com.sparta.endrmseha_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikePostRepository extends JpaRepository<LikePost, Long> {
    Optional<LikePost> findByUserAndPost(User user, Post post);
}
