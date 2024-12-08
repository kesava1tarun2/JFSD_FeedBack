package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.*;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    private String instructorName;
    private List<Long> courseIds; // List of Course IDs taught by this instructor
	public Long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public List<Long> getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(List<Long> courseIds) {
		this.courseIds = courseIds;
	}

    // Getters and Setters
}
