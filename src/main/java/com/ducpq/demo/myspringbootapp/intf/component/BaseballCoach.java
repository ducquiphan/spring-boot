package com.ducpq.demo.myspringbootapp.intf.component;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
	
	public BaseballCoach() {
		System.out.println("In constructor: " + this.getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "I'll hit you with my balls!";
	}
}
