package com.sparta.endrmseha_test.repository;

import com.sparta.endrmseha_test.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
