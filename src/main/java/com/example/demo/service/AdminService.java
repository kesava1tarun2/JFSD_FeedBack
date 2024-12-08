package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> login(Integer username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    public void registerAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Optional<Admin> findByUsername(Integer username) {
        return adminRepository.findByUsername(username);
    }
    
    public Admin getAdminProfile() {
        // Assuming there is only one admin, or you fetch the specific admin based on the session/user
        return adminRepository.findById(1).orElse(null); // Replace with actual logic
    }
}
