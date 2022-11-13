package com.jmcompany.dobaerang.domain.comment.repository;

import com.jmcompany.dobaerang.domain.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
