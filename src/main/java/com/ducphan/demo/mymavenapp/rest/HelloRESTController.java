package com.ducphan.demo.mymavenapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
	
	// inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	// expose "/" that return "Hello World"
	@GetMapping("/team-info")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", Team name: " + teamName;
	}
	
	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard workout!";
	}
	
	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day!";
	}
}
