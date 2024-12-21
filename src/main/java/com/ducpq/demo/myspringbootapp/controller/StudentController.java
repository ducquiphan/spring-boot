package com.ducpq.demo.myspringbootapp.controller;

import com.ducpq.demo.myspringbootapp.model.Country;
import com.ducpq.demo.myspringbootapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
	
	List<Country> countries;
	
	@GetMapping("/show-student-form")
	public String showForm(Model model) {
		countries = new ArrayList<>();
		countries.add(new Country("USA", "United States"));
		countries.add(new Country("VNI", "Vietnam"));
		countries.add(new Country("THA", "Thailand"));
		countries.add(new Country("GER", "Germany"));
		model.addAttribute("countries", countries);
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@PostMapping("/process-student-form/v1")
	public String processFormWithReqParams(@ModelAttribute("student") Student student) {
		
		System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());
		
		for (Country country : countries) {
			if (country.getValue().equals(student.getCountry().getValue())) {
				student.setCountry(country);
			}
		}
		
		return "student-confirmation";
	}
}
