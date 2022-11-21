package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
 
	@RequestMapping("/courses")
	public ResponseEntity<List<String>> getCourses(){
		List<String> courses = Arrays.asList("Spring Boot", "ReactJS", "VueJS");
		return ResponseEntity.ok(courses);
	}
}
