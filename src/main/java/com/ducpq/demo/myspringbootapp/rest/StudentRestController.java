package com.ducpq.demo.myspringbootapp.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	//	@GetMapping("")
	//	public List<Student> getListStudents() {
	//		List<Student> studentList = new ArrayList<>();
	//		studentList.add(new Student("Duc", "Phan"));
	//		studentList.add(new Student("Kevin", "Phan"));
	//		studentList.add(new Student("Thien", "Sky"));
	//		return studentList;
	//	}
	//
	//	@GetMapping("/{studentId}")
	//	public List<Student> getListStudents() {
	//		List<Student> studentList = new ArrayList<>();
	//		studentList.add(new Student("Duc", "Phan"));
	//		studentList.add(new Student("Kevin", "Phan"));
	//		studentList.add(new Student("Thien", "Sky"));
	//		return studentList;
	//	}
}
