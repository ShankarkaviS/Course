package com.course.enroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.enroll.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
	

}
