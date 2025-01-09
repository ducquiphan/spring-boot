package com.ducpq.demo.jpa.service;

import com.ducpq.demo.jpa.entity.Instructor;

public interface InstructorService {
	Instructor create(Instructor instructor);
	
	Instructor findById(int id);
	
	void deleteInstructorById(int id);
}
