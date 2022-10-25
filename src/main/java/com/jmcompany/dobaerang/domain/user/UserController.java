package com.jmcompany.dobaerang.domain.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login-form";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login-form";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.userSave(user);
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/admin-page")
    public String admin(){
        return "admin-page";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER')")
    @GetMapping("/user-page")
    public String user(){
        return "user-page";
    }

}
