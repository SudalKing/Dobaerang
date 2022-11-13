package com.jmcompany.dobaerang.domain.comment.service;

import com.jmcompany.dobaerang.domain.comment.dto.CommentDto;
import com.jmcompany.dobaerang.domain.comment.model.Comment;
import com.jmcompany.dobaerang.domain.comment.repository.CommentRepository;
import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.user.model.User;
import com.jmcompany.dobaerang.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    /**
     * Connect Comment to Post and Comment to User and Save them
     * @param userEmail Search User data
     * @param postId Search Post data
     * @param commentDto Transfer content data to CommentService
     */
    public void commentSave(String userEmail, Long postId, CommentDto commentDto){
        User user = userRepository.findByUsername(userEmail);

        Post post = postRepository.findById(postId).orElse(null);

        Comment comment = Comment.builder()
                .content(commentDto.getContent())
                .build();

        comment.setUser(user);
        comment.setPost(post);

        commentRepository.save(comment);

    }


}
