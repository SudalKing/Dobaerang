package com.jmcompany.dobaerang.domain.post;

import com.jmcompany.dobaerang.domain.user.User;
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
    public String postList(Model model,
                           @RequestParam(required = false, defaultValue = "")String searchText,
                           @PageableDefault(size = 5)Pageable pageable){
        Page<Post> postList = postRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);


        model.addAttribute("posts", postList);

        return "post/list";
    }

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

        String username = authentication.getName();
        postService.save(username, post);

        return "redirect:/post/list";
    }

    @GetMapping("/read")
    public String getRead(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("post", new Post());
        }
        else {
            Post post = postRepository.findById(id).orElse(null);
            model.addAttribute("post", post);
        }

        return "post/read";
    }


}
