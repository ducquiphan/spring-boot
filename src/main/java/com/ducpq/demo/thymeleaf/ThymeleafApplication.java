package com.ducpq.demo.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThymeleafApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(ThymeleafApplication.class, args);
	}
	
}
