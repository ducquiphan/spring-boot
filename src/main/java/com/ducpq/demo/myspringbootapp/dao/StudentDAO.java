package com.ducpq.demo.myspringbootapp.dao;

import com.ducpq.demo.myspringbootapp.entity.Student;

import java.util.List;

public interface StudentDAO {
	
	void save(Student student);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByLastName(String lastName);
	
	List<Student> findByEmail(String email);
	
	List<Student> findBySearchTerm(String searchTerm);
}
