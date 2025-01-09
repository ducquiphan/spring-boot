package com.ducpq.demo.jpa.service;

import com.ducpq.demo.jpa.entity.Instructor;
import com.ducpq.demo.jpa.entity.InstructorDetail;

public interface InstructorService {
	Instructor createInstructor(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	InstructorDetail findInstructorDetailById(int id);
	
	void deleteInstructorById(int id);
	
	void deleteInstructorDetailById(int id);
}
