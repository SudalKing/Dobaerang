package com.jmcompany.dobaerang.domain.comment.controller;

import com.jmcompany.dobaerang.domain.comment.dto.CommentDto;
import com.jmcompany.dobaerang.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public String postComment(
            @RequestParam(value = "postId", required = false) Long postId,
            @RequestParam(value = "content", required = false) String content,
            Authentication authentication){

        String userEmail = authentication.getName();

        CommentDto commentDto = CommentDto.builder()
                                .content(content)
                                .build();

        commentService.commentSave(userEmail, postId, commentDto);

        String redirectUrl = "redirect:/post/read?id=" + postId;

        return redirectUrl;
    }

}
