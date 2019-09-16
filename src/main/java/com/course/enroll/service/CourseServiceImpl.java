package com.course.enroll.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.enroll.entity.Course;
import com.course.enroll.exception.CourseNotFoundException;
import com.course.enroll.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Exception DataNotFoundException = null;
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourse() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	@Override
	public Course getCourseById(int courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if (!course.isPresent())
			throw new CourseNotFoundException("course id not found");
		return course.get();
	}

}
