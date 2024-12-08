package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to get the last logged-in user
    public User getLastLoggedInUser() {
        User user = userRepository.findTopByOrderByLastLoginDesc(); // Get the user with the most recent lastLogin
        return user; // Return the user (could be null if no users found)
    }

    // Other methods you may already have
    public void updateUserOnLogin(String userId, String name, String role) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            user = new User(userId, name, role);
        } else {
            user.setName(name);
            user.setRole(role);
        }

        // Update the lastLogin timestamp
        user.setLastLogin(LocalDateTime.now());

        userRepository.save(user);
    }

    // Get user details by userId
    public User getUserById(String userId) {
        return userRepository.findByUserId(userId);
    }
}
