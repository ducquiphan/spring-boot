package com.ducpq.demo.myspringbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/show-form")
	public String showForm() {
		return "hello-world-form";
	}
	
	@RequestMapping("/process-form")
	public String processForm() {
		return "hello-world";
	}
}
