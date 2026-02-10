package com.example.auth.AuthApplication.Service;

import com.example.auth.AuthApplication.Entity.User;
import com.example.auth.AuthApplication.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public String signup(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists";
        }

        // encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public String login(User user) {

        User dbUser = userRepository
                .findByUsername(user.getUsername())
                .orElse(null);

        if (dbUser == null) {
            return "Invalid username or password";
        }

        boolean match = passwordEncoder
                .matches(user.getPassword(), dbUser.getPassword());

        if (match) {
            return "Login successful";
        }
        return "Invalid username or password";
    }
}



