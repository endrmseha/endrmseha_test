package com.sparta.endrmseha_test.repository;

import com.sparta.endrmseha_test.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
