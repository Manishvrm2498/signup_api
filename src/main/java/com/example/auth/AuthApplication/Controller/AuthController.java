package com.example.auth.AuthApplication.Controller;

import com.example.auth.AuthApplication.Entity.User;
import com.example.auth.AuthApplication.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return authService.signup(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.login(user);
    }
}

