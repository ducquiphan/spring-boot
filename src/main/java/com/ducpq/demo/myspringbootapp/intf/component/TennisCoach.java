package com.ducpq.demo.myspringbootapp.intf.component;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach {
	
	public TennisCoach() {
		System.out.println("In constructor: " + this.getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "I'll hit you with my balls harder than Baseball!";
	}
}
