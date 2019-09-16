package com.course.enroll.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.course.enroll.entity.Course;
import com.course.enroll.service.CourseService;


@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

	

	@Mock
	 CourseService courseService;
	
	@InjectMocks
	CourseController courseController;
	
	@Test
	public void testCourseById() {
			Course course = new Course();
			course.setCourseId(1);
			course.setCourseName("Java");
			course.setDuration("5month");
		Mockito.when(courseService.getCourseById(Mockito.anyInt())).thenReturn(course);
		ResponseEntity<Course> course1 = courseController.getCourse(1);
		assertEquals(course.getCourseId(), course1.getBody().getCourseId());
		
	}

	@Test
	public void testCourseList() {
		List<Course> courseList= new ArrayList<Course>();
			Course course = new Course();
			course.setCourseId(1);
			course.setCourseName("Java");
			course.setDuration("5month");
			
			Course course1 = new Course();
			course.setCourseId(2);
			course.setCourseName(".net");
			course.setDuration("4month");
			courseList.add(course);
			courseList.add(course1);
			
		Mockito.when(courseService.getAllCourse()).thenReturn(courseList);
		ResponseEntity<List<Course>> courses = courseController.getAllCourse();
		assertEquals(courseList.size(),  courses.getBody().size());
		
	}
	
	
	
	


}
