package com.ducpq.demo.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails ducphan = User.builder().username("ducphan")
				.password("{noop}test123")
				.roles("EMPLOYEE").build();
		UserDetails bin = User.builder().username("bin")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER").build();
		UserDetails thiensky = User.builder().username("thiensky")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
		return new InMemoryUserDetailsManager(ducphan, bin, thiensky);
	}
}
