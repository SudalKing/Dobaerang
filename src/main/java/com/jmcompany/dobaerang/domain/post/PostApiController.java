package com.jmcompany.dobaerang.domain.post;

import com.jmcompany.dobaerang.domain.user.UserRepository;
import com.jmcompany.dobaerang.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
