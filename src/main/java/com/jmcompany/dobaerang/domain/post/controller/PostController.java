package com.jmcompany.dobaerang.domain.post.controller;

import com.jmcompany.dobaerang.domain.comment.model.Comment;
import com.jmcompany.dobaerang.domain.comment.repository.CommentRepository;
import com.jmcompany.dobaerang.domain.comment.service.CommentService;
import com.jmcompany.dobaerang.domain.post.dto.PostDto;
import com.jmcompany.dobaerang.domain.post.model.Post;
import com.jmcompany.dobaerang.domain.post.repository.PostRepository;
import com.jmcompany.dobaerang.domain.post.service.PostService;
import com.jmcompany.dobaerang.domain.post.validator.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private PostValidator postValidator;

    @GetMapping("/list")
    public String getList(Model model,
                           @RequestParam(required = false, defaultValue = "")String searchText,
                           @PageableDefault(size = 25)Pageable pageable){
        Page<Post> postList = postRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);


        model.addAttribute("posts", postList);

        return "post/list";
    }

    // ================================ form ===============================
    @GetMapping("/form")
    public String getForm(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("post", new Post());
        }
        else {
            Post post = postRepository.findById(id).orElse(null);
            model.addAttribute("post", post);
        }

        return "post/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Post post, BindingResult bindingResult, Authentication authentication){
        postValidator.validate(post, bindingResult);

        if(bindingResult.hasErrors()){
            return "post/form";
        }

        String userEmail = authentication.getName();
        postService.postSave(userEmail, post);

        return "redirect:/post/list";
    }
    // ===============================================================

    // =========================== read ==============================
    @GetMapping("/read")
    public String getRead(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("post", new Post());
        }
        else {
            Post post = postRepository.findById(id).orElse(null);
            model.addAttribute("post", post);

            if (post != null) {
                List<Comment> comments = post.getComments();
                model.addAttribute("comments", comments);
            }
        }

        return "post/read";
    }

    @DeleteMapping("/read/{postId}")
    public String deletePost(@PathVariable Long postId, String currentUsername){
        postService.postDelete(postId, currentUsername);

        return "redirect:/post/list";
    }
    // ===============================================================

    // ============================ modify ===========================
    @GetMapping("/modify")
    public String getModify(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("post", new Post());
        }
        else {
            Post post = postRepository.findById(id).orElse(null);
            model.addAttribute("post", post);
        }

        return "post/modify";
    }

    @PostMapping("/modify")
    public String replacePost(@RequestParam Long postId,
                              String newTitle,
                              String newContent,
                              Authentication authentication){
        String userEmail = authentication.getName();

        PostDto postDto = PostDto.builder()
                        .id(postId)
                        .title(newTitle)
                        .content(newContent)
                        .build();

        postService.postModify(postDto, userEmail);

        return "redirect:/post/list";
    }

}
