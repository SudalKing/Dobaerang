package com.jmcompany.dobaerang.domain.post.service;

import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.user.model.User;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    /**
     * Connect Post to User and Save them
     * @param userEmail Search User data
     * @param post Get Post data that the user sends from view(form.html)
     */
    public void postSave(String userEmail, Post post){
        User user = userRepository.findByUsername(userEmail);
        post.setUser(user);
        postRepository.save(post);
    }


}
