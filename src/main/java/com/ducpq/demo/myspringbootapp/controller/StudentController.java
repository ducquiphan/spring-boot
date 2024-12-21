package com.ducpq.demo.myspringbootapp.controller;

import com.ducpq.demo.myspringbootapp.model.Country;
import com.ducpq.demo.myspringbootapp.model.Gender;
import com.ducpq.demo.myspringbootapp.model.Hobby;
import com.ducpq.demo.myspringbootapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
	
	List<Country> countries;
	List<Gender> genders;
	List<Hobby> hobbies;
	
	@GetMapping("/show-student-form")
	public String showForm(Model model) {
		countries = new ArrayList<>();
		countries.add(new Country("USA", "United States"));
		countries.add(new Country("VNI", "Vietnam"));
		countries.add(new Country("THA", "Thailand"));
		countries.add(new Country("GER", "Germany"));
		
		genders = new ArrayList<>();
		genders.add(new Gender(true, "Male"));
		genders.add(new Gender(false, "Female"));
		
		hobbies = new ArrayList<>();
		hobbies.add(new Hobby(1, "Singing"));
		hobbies.add(new Hobby(2, "Dancing"));
		hobbies.add(new Hobby(3, "Coding"));
		hobbies.add(new Hobby(4, "Testing"));
		
		model.addAttribute("countries", countries);
		model.addAttribute("genders", genders);
		model.addAttribute("hobbies", hobbies);
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@PostMapping("/process-student-form/v1")
	public String processFormWithReqParams(@ModelAttribute("student") Student student, Model model) {
		
		System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());
		
		for (Country country : countries) {
			if (country.getValue().equals(student.getCountry().getValue())) {
				student.setCountry(country);
			}
		}
		
		student.setGender(genders.stream().filter(gender -> {
			return gender.isValue() == student.getGender().isValue();
		}).findFirst().orElse(null));
		
		List<String> studentHobbies = new ArrayList<>();
		
		for (Integer hobbyId : student.getHobbyIds()) {
			studentHobbies.add(hobbies.stream().filter(hobby -> {
				return hobby.getId().equals(hobbyId);
			}).map(Hobby::getValue).findFirst().orElse(""));
		}
		
		model.addAttribute("studentHobbies", studentHobbies);
		
		return "student-confirmation";
	}
}
