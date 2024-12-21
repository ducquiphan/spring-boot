package com.ducpq.demo.myspringbootapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	@GetMapping("/show-form")
	public String showForm() {
		return "hello-world-form";
	}
	
	@RequestMapping("/process-form/v1")
	public String processForm() {
		return "hello-world";
	}
	
	// need a controller method to read form data
	// and add data to the model
	@RequestMapping("/process-form/v2")
	public String processFormWithRequest(HttpServletRequest request, Model model) {
		// read the request param
		String name = request.getParameter("studentName");
		
		// convert data to all caps
		name = name.toUpperCase();
		
		// create new message
		String message = "Yo! Your name is " + name;
		
		// add message to the model
		model.addAttribute("message", message);
		return "hello-world";
	}
	
	@PostMapping("/process-form/v3")
	public String processFormWithReqParams(@RequestParam("studentName") String studentName, Model model) {
		// convert data to all caps
		studentName = studentName.toUpperCase();
		
		// create new message
		String message = "Yo! Your name is " + studentName;
		
		// add message to the model
		model.addAttribute("message", message);
		return "hello-world";
	}
}
