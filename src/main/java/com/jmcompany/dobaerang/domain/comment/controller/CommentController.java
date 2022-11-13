package com.jmcompany.dobaerang.domain.comment.controller;

import com.jmcompany.dobaerang.domain.comment.dto.CommentDto;
import com.jmcompany.dobaerang.domain.comment.model.Comment;
import com.jmcompany.dobaerang.domain.comment.repository.CommentRepository;
import com.jmcompany.dobaerang.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/post")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

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
