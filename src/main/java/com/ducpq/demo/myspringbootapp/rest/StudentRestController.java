package com.ducpq.demo.myspringbootapp.rest;

import com.ducpq.demo.myspringbootapp.entity.Student;
import com.ducpq.demo.myspringbootapp.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	private List<Student> studentList;
	
	// define @PostConstruct to load students data only once
	@PostConstruct
	public void loadData() {
		studentList = new ArrayList<>();
		this.studentList.add(new Student("Duc", "Phan"));
		this.studentList.add(new Student("Kevin", "Phan"));
		this.studentList.add(new Student("Thien", "Sky"));
	}
	
	@GetMapping("")
	public List<Student> getListStudents() {
		return this.studentList;
	}
	
	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (studentId >= studentList.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id is not found - " + studentId);
		}
		return this.studentList.get(studentId);
	}
}
