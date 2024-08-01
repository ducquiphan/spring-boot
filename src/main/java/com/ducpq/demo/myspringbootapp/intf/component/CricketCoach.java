package com.ducpq.demo.myspringbootapp.intf.component;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In constructor: " + this.getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice for Cricket Coach!! Hello guys";
	}
}
