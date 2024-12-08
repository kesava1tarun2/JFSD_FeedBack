package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.InstitutionalService;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.InstitutionalServiceRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/student-dashboard")
public class StudentDashboardController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstitutionalServiceRepository institutionalServiceRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Autowired
    private FeedbackService feedbackService;
    
    @GetMapping
    public String showStudentDashboard() {
        return "student-dashboard";
    }

    @GetMapping("/student/give-feedback")
    public String showGiveFeedbackForm(Model model) {
        // Retrieve the list of courses, instructors, and services
        List<Course> courses = courseRepository.findAll();
        List<Instructor> instructors = instructorRepository.findAll();
        List<InstitutionalService> services = institutionalServiceRepository.findAll();

        // Add attributes to the model
        model.addAttribute("courses", courses);
        model.addAttribute("instructors", instructors);
        model.addAttribute("services", services);
        model.addAttribute("feedback", new Feedback());

        return "student/give-feedback"; // Refers to the name of your JSP or Thymeleaf file
    }
    
    @Autowired
    private UserService userService;
    @PostMapping("/student/give-feedback")
    public String submitFeedback(@RequestParam("category") String category,
                                 @RequestParam(value = "course", required = false) String courseName,
                                 @RequestParam(value = "instructor", required = false) String instructorName,
                                 @RequestParam(value = "service", required = false) String serviceName,
                                 @RequestParam("feedback") String feedbackText,
                                 @RequestParam("username") String username) {
        // Create a new Feedback object
        Feedback feedback = new Feedback();
        feedback.setCategory(category);

        // Set the specific details based on the selected category
        if ("course".equals(category)) {
            feedback.setCourseName(courseName);
        } else if ("instructor".equals(category)) {
            feedback.setInstructorName(instructorName);
        } else if ("service".equals(category)) {
            feedback.setServiceName(serviceName);
        }

        feedback.setFeedback(feedbackText); // Set the provided feedback
        feedback.setUsername(username); // Set the student's username

        // Save feedback to the database
        feedbackRepository.save(feedback);

        // Redirect to the same form after submission
        return "redirect:/student-dashboard";
    }
    
    @GetMapping("/student/view-feedback")
    public String viewFeedback(Model model) {
    	
    	User user = userService.getLastLoggedInUser();
        List<Feedback> feedbackList = feedbackRepository.findByUsername(user.getUserId());

        model.addAttribute("feedbackList", feedbackList);

        return "student/view-feedback"; 
    }
    
    @GetMapping("/student/delete-feedback")
    public String deleteFeedback(@RequestParam("feedbackId") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId); // Call the service to delete the feedback
        return "redirect:/student-dashboard/student/view-feedback"; // Redirect to the view feedback page
    }
    
    @GetMapping("/student/profile")
    public String getLastLoggedInUserProfile(Model model) {
        // Fetch the last logged-in user from the database
        User user = userService.getLastLoggedInUser();  // Calling the service method to get the last logged-in user
        
        if (user != null) {
            // Add user details to the model
            model.addAttribute("user", user);
        } else {
            model.addAttribute("error", "No users found");
        }

        return "admin/profile"; // Thymeleaf template to show the user profile
    }
}
