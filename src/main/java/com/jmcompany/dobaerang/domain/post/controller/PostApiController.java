package com.jmcompany.dobaerang.domain.post.controller;

import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.post.service.PostService;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import com.jmcompany.dobaerang.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class PostApiController {

    private final PostRepository postRepository;

    private final PostService postService;

    private final UserRepository userRepository;

    private final UserService userService;

    public PostApiController(PostRepository postRepository, PostService postService, UserRepository userRepository, UserService userService) {
        this.postRepository = postRepository;
        this.postService = postService;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/read/{id}")
    public Post getRead(@PathVariable Long id){
        return postRepository.findById(id)
                .orElse(null);
    }


}
