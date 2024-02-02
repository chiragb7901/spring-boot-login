package com.Sunbase.dev.service;

import com.Sunbase.dev.repository.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final com.Sunbase.dev.repository.UserRepository userRepository;

    public UserService(com.Sunbase.dev.repository.UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // Add logic to check if the username or email is already registered before saving the user

        return userRepository.save(user);
    }

    public Optional<User> loginUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> password.equals(user.getPassword()));
    }
}
