package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    private int passOutYear;

    // Default constructor (required by JPA)
    public Course() {}

    // Parameterized constructor for convenience
    public Course(String courseName, int passOutYear) {
        this.courseName = courseName;
        this.passOutYear = passOutYear;
    }

    // Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPassOutYear() {
        return passOutYear;
    }

    public void setPassOutYear(int passOutYear) {
        this.passOutYear = passOutYear;
    }

    // Optional: toString method for easier debugging/logging
    @Override
    public String toString() {
        return "Course{" +
               "courseId=" + courseId +
               ", courseName='" + courseName + '\'' +
               ", passOutYear=" + passOutYear +
               '}';
    }
}
