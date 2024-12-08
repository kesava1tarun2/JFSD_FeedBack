package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String username;  // Username of the student giving feedback
    
    private String feedback;  // The feedback text

    private String category;  // Category: Course, Instructor, or Service

    private String courseName;    // Course name (if category is "Course")
    private String instructorName; // Instructor name (if category is "Instructor")
    private String serviceName;    // Service name (if category is "Service")
    private Integer rating;

    // Constructors
    public Feedback() {}

    public Feedback(String username, String feedback, String category, String courseName, String instructorName, String serviceName) {
        this.username = username;
        this.feedback = feedback;
        this.category = category;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.serviceName = serviceName;
    }

    // Getters and Setters
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
}