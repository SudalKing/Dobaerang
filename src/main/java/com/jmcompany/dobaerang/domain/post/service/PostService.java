package com.jmcompany.dobaerang.domain.post.service;

import com.jmcompany.dobaerang.domain.post.dto.PostDto;
import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.user.model.User;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Can delete the post if the post writer equals currentUsername or admin
     * @param postId Search Post data
     * @param currentUsername The current username for comparing to post writer
     */
    public void postDelete(Long postId, String currentUsername){
        Post post = postRepository.findById(postId).orElse(null);

        assert post != null;
        String username = post.getUser().getUsername();

        if(username.equals(currentUsername) || currentUsername.equals("admin")){
            postRepository.deleteById(postId);
        }
    }

    /**
     * Can modify the post if the post writer equals currentUsername
     * @param postDto Dto for post(id, title, content)
     * @param currentUsername The current username for comparing to post writer
     */
    public void postModify(PostDto postDto, String currentUsername) {
        Long postId = postDto.getId();

        Post post = postRepository.findById(postId).orElse(null);

        assert post != null;
        if (currentUsername.equals(post.getUser().getUsername())) {
            postRepository.findById(postId)
                    .map(newPost -> {
                        newPost.setTitle(postDto.getTitle());
                        newPost.setContent(postDto.getContent());
                        return postRepository.save(newPost);
                    })
                    .orElseGet(null);
        }
    }

}
