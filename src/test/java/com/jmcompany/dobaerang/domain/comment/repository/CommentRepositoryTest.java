package com.jmcompany.dobaerang.domain.comment.repository;

import com.jmcompany.dobaerang.domain.comment.model.Comment;
import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.user.model.User;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @DisplayName("[Comment] BasicRepositoryTest")
    @Test
    @Transactional
    void comment(){
        givenComment();

        List<Comment> comments = commentRepository.findAll();

        comments.forEach(System.out::println);

    }

    void givenComment(){
        User user = userRepository.findAll().get(0);

        Post post = user.getPosts().get(0);

        Comment comment = Comment.builder().content("zz 나도 재밌었음").build();
        Comment comment1 = Comment.builder().content("ㄹㅇ 재밌었음").build();

        commentRepository.save(comment);
        commentRepository.save(comment1);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment1);

        post.setComments(comments);

        commentRepository.saveAll(comments);
        postRepository.save(post);

    }

}