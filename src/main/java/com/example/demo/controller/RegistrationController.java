package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
@Controller
public class RegistrationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/student/register")
    public String showStudentRegistrationPage() {
        return "student-register";
    }

    @PostMapping("/student/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentService.registerStudent(student);
        return "redirect:/";
    }

    @GetMapping("/admin/register")
    public String showAdminRegistrationPage() {
        return "admin-register";
    }

    @PostMapping("/admin/register")
    public String registerAdmin(@ModelAttribute Admin admin) {
        adminService.registerAdmin(admin);
        return "redirect:/";
    }
}
