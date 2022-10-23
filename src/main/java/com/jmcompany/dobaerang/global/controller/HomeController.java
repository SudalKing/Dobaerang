package com.jmcompany.dobaerang.global.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main(){
        return "index";
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

    @ResponseBody
    @GetMapping("/auth")
    public Authentication auth(){
        return SecurityContextHolder.getContext().getAuthentication();
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
