package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course); // Save to the database
    }

	public void deleteCourseById(Long id) {
		 courseRepository.deleteById(id);
		
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
}
