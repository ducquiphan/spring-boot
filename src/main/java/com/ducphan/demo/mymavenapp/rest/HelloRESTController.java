package com.ducphan.demo.mymavenapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}
}
