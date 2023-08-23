package com.sparta.endrmseha_test.repository;

import com.sparta.endrmseha_test.entity.Comment;
import com.sparta.endrmseha_test.entity.LikeComment;
import com.sparta.endrmseha_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    Optional<LikeComment> findByUserAndComment(User user, Comment comment);
}
