package com.jmcompany.dobaerang.domain.post;

import com.jmcompany.dobaerang.domain.user.User;
import com.jmcompany.dobaerang.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post save(String username, Post post){
        User user = userRepository.findByUsername(username);
        post.setUser(user);
        return postRepository.save(post);
    }


}
