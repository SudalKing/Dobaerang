package com.jmcompany.dobaerang.domain.post;

import com.jmcompany.dobaerang.domain.comment.model.Comment;
import com.jmcompany.dobaerang.domain.comment.repository.CommentRepository;
import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.post.service.PostService;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager em;

    @DisplayName("[Save] join user_id")
    @Test
    void postServiceSave(){
        String searchUsername = "user1";

        Post post = postRepository.findAll().get(0);

        postService.postSave(searchUsername, post);

        System.out.println(post);
    }

    @DisplayName("[Delete] delete post with comments")
    @Test
    void postDelete(){
        Post post = postRepository.findById(1L).orElse(null);
        System.out.println(">>> " + post);

        postService.postDelete(1L, "admin");

    }

}