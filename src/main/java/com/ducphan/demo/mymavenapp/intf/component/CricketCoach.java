package com.ducphan.demo.mymavenapp.intf.component;

import com.ducphan.demo.mymavenapp.intf.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "Practice for Cricket Coach!";
	}
}
