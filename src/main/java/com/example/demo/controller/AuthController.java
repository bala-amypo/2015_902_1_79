package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    // Constructor injection (recommended)
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Register API
    @PostMapping(
            value = "/register",
            consumes = "application/json",
            produces = "application/json"
    )
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // Login API (dummy for now)
    @PostMapping(
            value = "/login",
            consumes = "application/json",
            produces = "application/json"
    )
    public String login(@RequestBody User user) {
        return "Login successful";
    }
}