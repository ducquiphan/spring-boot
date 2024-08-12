package com.ducpq.demo.myspringbootapp.intf.component;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {
	
	public BaseballCoach() {
		System.out.println("In constructor: " + this.getClass().getSimpleName());
	}
	
	// define init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("This is doMyStartUpStuff(): " + getClass().getSimpleName());
	}
	
	// define destroy method
	public void doMyCleanUpStuff() {
		System.out.println("This is doMyCleanUpStuff(): " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "I'll hit you with my balls!";
	}
}
