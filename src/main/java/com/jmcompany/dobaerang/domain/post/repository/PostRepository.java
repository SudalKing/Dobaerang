package com.jmcompany.dobaerang.domain.post.repository;

import com.jmcompany.dobaerang.domain.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    List<Post> findAllByTitleContaining(String searchTextTitle);

    List<Post> findAllByContentContaining(String searchTextContent);

    Post findByTitle(String searchTextTitle);

}
