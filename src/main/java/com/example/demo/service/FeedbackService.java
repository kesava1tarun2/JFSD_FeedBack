package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository; // Ensure you have a repository for Feedback

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll(); // Fetch all feedbacks from the database
    }
    
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId); // Deletes feedback by its ID
    }
}
