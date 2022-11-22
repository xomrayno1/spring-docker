package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseDTO;
import com.app.entity.Course;
import com.app.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepo;
 
	@RequestMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		List<Course> courses = courseRepo.findAll();
		return ResponseEntity.ok(courses);
	}
	
	@PostMapping("/add-course")
	public ResponseEntity<String> addCourse(@RequestBody CourseDTO courseDTO){
		Course course = new Course();
		course.setName(courseDTO.getName());
		courseRepo.save(course);
		return ResponseEntity.ok("add success");
	}
}
