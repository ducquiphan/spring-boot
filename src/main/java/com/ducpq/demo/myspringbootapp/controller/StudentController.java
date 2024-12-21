package com.ducpq.demo.myspringbootapp.controller;

import com.ducpq.demo.myspringbootapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
	
	@GetMapping("/show-student-form")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@PostMapping("/process-student-form/v1")
	public String processFormWithReqParams(@ModelAttribute("student") Student student) {
		
		System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());
		
		return "student-confirmation";
	}
}
