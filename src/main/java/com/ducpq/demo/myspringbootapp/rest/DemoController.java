package com.ducpq.demo.myspringbootapp.rest;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	// define a private field for the dependency
	private final Coach myCoach;
	
	// define a constructor for dependency injection
	@Autowired
	public DemoController(@Qualifier("baseballCoach") Coach coach) {
		myCoach = coach;
	}
	
	@GetMapping("/daily-workout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
