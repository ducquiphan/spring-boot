package com.ducpq.demo.myspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = { "com.ducpq.demo.myspringbootapp",
//				"com.ducpq.demo.utils" })
@SpringBootApplication
public class MyspringbootappApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyspringbootappApplication.class, args);
	}
	
}
