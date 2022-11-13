package com.jmcompany.dobaerang.domain.post;

import com.jmcompany.dobaerang.domain.user.User;
import com.jmcompany.dobaerang.domain.user.UserRepository;
import com.jmcompany.dobaerang.domain.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("[Save] join user_id")
    @Test
    void postServiceSave(){
        String searchUsername = "user1";

        Post post = postRepository.findAll().get(0);

        postService.save(searchUsername, post);

        System.out.println(post);
    }

}