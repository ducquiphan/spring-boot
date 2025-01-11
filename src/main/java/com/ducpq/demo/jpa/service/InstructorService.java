/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.jpa.service;

import com.ducpq.demo.jpa.entity.Course;
import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;

import java.util.List;

public interface InstructorService {
	Instructor createInstructor(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	InstructorDetail findInstructorDetailById(int id);
	
	Instructor updateInstructor(Instructor instructor);
	
	Course updateCourse(Course course);
	
	Course findCourseById(int id);
	
	void deleteInstructorById(int id);
	
	void deleteInstructorDetailById(int id);
	
	void deleteCourseById(int id);
	
	List<Course> findCourseByInstructorId(int id);
	
	InstructorDetail findInstructorDetailByInstructorId(int id);
}
