package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);

    List<Course> getAllCourses();

    void deleteCourseById(Long id);
}
