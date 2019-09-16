package com.course.enroll.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.course.enroll.entity.Course;
import com.course.enroll.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {

	@Autowired
	CourseService courseService;
	@MockBean
	CourseRepository courseRepository;

	@Test
	public void getAllCourse() {
		List<Course> courseList = new ArrayList<>();
		courseList.add(new Course(1, "Java", "6Month"));
		Mockito.when(courseRepository.findAll()).thenReturn(courseList);
		List<Course> user = courseService.getAllCourse();
		assertThat(user.size()).isEqualTo(1);
	}

	@Test
	public void getCourses() {
		Course c1 = new Course(2, "autocad", "3month");
		Mockito.when(courseRepository.findById(2)).thenReturn(Optional.of(c1));
		int courseId = 2;
		Course course = courseService.getCourseById(courseId);
		assertThat(course.getCourseName()).isEqualTo("autocad");
	}

}
