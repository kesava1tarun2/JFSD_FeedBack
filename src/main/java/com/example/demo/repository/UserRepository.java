package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUserId(String userId);

    // Custom method to find the user with the latest lastLogin
    User findTopByOrderByLastLoginDesc();
}
