package com.course.enroll.service;

import java.util.List;

import com.course.enroll.entity.Course;

public interface CourseService {
	
	public List<Course> getAllCourse();
	
	public Course getCourseById(int courseId);

}
