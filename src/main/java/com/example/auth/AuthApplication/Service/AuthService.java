package com.example.auth.AuthApplication.Service;
import com.example.auth.AuthApplication.Entity.User;

public interface AuthService {

    String signup(User user);
    String login(User user);
}

