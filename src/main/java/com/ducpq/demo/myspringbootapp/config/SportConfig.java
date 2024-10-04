package com.ducpq.demo.myspringbootapp.config;

import com.ducpq.demo.myspringbootapp.intf.Coach;
import com.ducpq.demo.myspringbootapp.intf.component.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
