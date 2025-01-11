package com.ducpq.demo.jpa.service;

import com.ducpq.demo.jpa.entity.Course;
import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;

import java.util.List;

public interface InstructorService {
	Instructor createInstructor(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	InstructorDetail findInstructorDetailById(int id);
	
	Instructor update(Instructor instructor);
	
	void deleteInstructorById(int id);
	
	void deleteInstructorDetailById(int id);
	
	List<Course> findCourseByInstructorId(int id);
	
	InstructorDetail findInstructorDetailByInstructorId(int id);
}
