package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @Column(nullable = false, unique = true)
    private String loginUsername;  // Username

    @Column(nullable = false)
    private String password;  // Password

    private LocalDateTime loginTime;  // Time of login

    public Login() {
    }

    // Updated constructor
    public Login(String loginUsername, LocalDateTime loginTime) {
        this.loginUsername = loginUsername;
        this.loginTime = loginTime;
    }

    // Constructor including password if needed
    public Login(String loginUsername, String password, LocalDateTime loginTime) {
        this.loginUsername = loginUsername;
        this.password = password;
        this.loginTime = loginTime;
    }

    // Getters and Setters
    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}
