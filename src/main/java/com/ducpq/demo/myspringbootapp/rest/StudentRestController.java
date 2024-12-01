package com.ducpq.demo.myspringbootapp.rest;

import com.ducpq.demo.myspringbootapp.entity.Student;
import com.ducpq.demo.myspringbootapp.exception.StudentNotFoundException;
import com.ducpq.demo.myspringbootapp.responsemessage.ResponseMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(StudentNotFoundException e) {
		ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
