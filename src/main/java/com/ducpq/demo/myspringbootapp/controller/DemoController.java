package com.ducpq.demo.myspringbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DemoController {
	
	//create a mapping for "hello"
	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("theDate", LocalDateTime.now());
		return "index";
	}
}
