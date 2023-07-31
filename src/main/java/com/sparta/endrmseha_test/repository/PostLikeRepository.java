package com.sparta.endrmseha_test.repository;

import com.sparta.endrmseha_test.entity.Post;
import com.sparta.endrmseha_test.entity.PostLike;
import com.sparta.endrmseha_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserAndPost(User user, Post post);
    Boolean existsByUserAndPost(User user, Post post);
}
