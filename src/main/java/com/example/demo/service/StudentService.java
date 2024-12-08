package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> login(Long username, String password) {
        return studentRepository.findByUsernameAndPassword(username, password);
    }

    public void registerStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findByUsername(Long username) {
        return studentRepository.findByUsername(username);
    }
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }
    
}
