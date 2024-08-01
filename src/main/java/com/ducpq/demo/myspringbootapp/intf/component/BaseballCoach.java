package com.ducpq.demo.myspringbootapp.intf.component;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "I'll hit you with my balls!";
	}
}
