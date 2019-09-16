package com.course.enroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.enroll.entity.Course;
import com.course.enroll.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/getAllCourse")
	public ResponseEntity<List<Course>> getAllCourse() {
		
		return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
	}

	@PostMapping("/getCourse/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable("id") int courseId) {

		return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);

	}

}
