package com.ducpq.demo.myspringbootapp.intf.component;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {
	
	public BaseballCoach() {
		System.out.println("In constructor: " + this.getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "I'll hit you with my balls!";
	}
}
