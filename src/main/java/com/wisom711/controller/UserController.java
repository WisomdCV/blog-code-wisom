package com.wisom711.controller;


import com.wisom711.entity.UserEntity;
import com.wisom711.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/record")
    public String recordPage(){
        return "/users/register";
    }

    @PostMapping("/register")
    public String register(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = {"/login", "/"})
    public String loginPage(){
        return "/users/login";
    }

}
