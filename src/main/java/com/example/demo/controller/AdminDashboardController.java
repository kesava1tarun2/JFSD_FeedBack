package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.service.AdminService;
import com.example.demo.service.CourseService;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.InstitutionalServiceService;
import com.example.demo.service.InstructorService;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/admin-dashboard")
public class AdminDashboardController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private InstitutionalServiceService institutionalServiceService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    // Show Admin Dashboard
    @GetMapping
    public String showAdminDashboard() {
        return "admin-dashboard"; // Main dashboard view for admins
    }

 // Show Add Course Form
    @GetMapping("/admin/add-course")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course()); // Bind form to a new Course object
        List<Course> courses = courseService.getAllCourses(); // Fetch all courses from the service
        model.addAttribute("courses", courses); // Add the list of courses to the model
        return "admin/add-course"; // Form to add a new course
    }

    // Add a Course
    @PostMapping("/admin/add-course")
    public String addCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course); // Save the new course
        return "redirect:/admin-dashboard/admin/add-course"; // Redirect back to the form
    }
    
    @PostMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/admin-dashboard/admin/add-course";
    }

    @GetMapping("/admin/instructors")
    public String viewInstructors(Model model) {
        List<Instructor> instructors = instructorService.getAllInstructors(); // Fetch all instructors from the service
        model.addAttribute("instructors", instructors); // Add the list of instructors to the model
        return "admin/instructors"; // JSP or Thymeleaf page to display the list of instructors
    }

    // Show details of a specific instructor
    @GetMapping("/admin/instructor/{id}")
    public String viewInstructorDetails(@PathVariable Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id); // Fetch the instructor by ID
        if (instructor != null) {
            model.addAttribute("instructor", instructor); // Add the instructor to the model
        } else {
            model.addAttribute("error", "Instructor not found"); // In case the instructor is not found
        }
        return "admin/instructor-details"; // JSP or Thymeleaf page to display the instructor's details
    }

    
    // Show Add Instructor Form
    @GetMapping("/admin/add-instructor")
    public String showAddInstructorForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "admin/add-instructor"; // Form to add a new instructor
    }

    // Add an Instructor
    @PostMapping("/admin/add-instructor")
    public String addInstructor(@ModelAttribute Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/admin-dashboard/admin/add-instructor"; // Redirect back to admin dashboard
    }

    // Show Add Service Form
    @GetMapping("/admin/add-service")
    public String showAddServiceForm(Model model) {
        model.addAttribute("service", new InstitutionalService());
        return "admin/add-service"; // Form to add a new institutional service
    }

    // Add an Institutional Service
    @PostMapping("/admin/add-service")
    public String addService(@ModelAttribute InstitutionalService service) {
        institutionalServiceService.saveService(service);
        return "redirect:/admin-dashboard/admin/add-service"; // Redirect back to admin dashboard
    }

    // View Feedbacks
    @GetMapping("/admin/view-feedback")
    public String viewFeedback(Model model) {
        // Fetch all feedbacks from the service layer
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        model.addAttribute("feedbacks", feedbacks);
        return "admin/view-feedback"; // JSP page for displaying feedbacks
    }
    
    @GetMapping("/admin/delete-feedback")
    public String deleteFeedback(@RequestParam("feedbackId") Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId); // Call the service to delete the feedback
        return "redirect:/admin-dashboard/admin/view-feedback"; // Redirect to the view feedback page
    }

    // View User Profile
    @GetMapping("/admin/profile")
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
