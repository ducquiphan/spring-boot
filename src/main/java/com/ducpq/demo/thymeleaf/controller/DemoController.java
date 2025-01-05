package com.ducpq.demo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DemoController {
	
	@GetMapping("")
	public String index() {
		return "home";
	}
	
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	@GetMapping("/admins")
	public String showAdmins() {
		return "admins";
	}
}
