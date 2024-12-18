package com.ducpq.demo.myspringbootapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
	
	// add support for JDBC ... no more hard code users
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		// define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"SELECT username, password, is_active FROM users WHERE username = ?"
		);
		
		// define query to retrieve the authorities / roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"SELECT username, role FROM roles r " +
						"INNER JOIN user_roles ur ON ur.role_id = r.id " +
						"INNER JOIN users u ON u.id = ur.user_id " +
						"WHERE username = ?"
		);
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
				configurer
						.requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE", "MANAGER")
						.requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE", "MANAGER")
						.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
						.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
						.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
		);
		
		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery (CSRF)
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	
	//	@Bean
	//	public InMemoryUserDetailsManager userDetailsManager() {
	//		UserDetails ducphan = User.builder()
	//				.username("ducphan")
	//				.password("{noop}quiduc123")
	//				.roles("EMPLOYEE")
	//				.build();
	//		UserDetails skythien = User.builder()
	//				.username("thiensky")
	//				.password("{noop}thien123")
	//				.roles("EMPLOYEE", "MANAGER", "ADMIN")
	//				.build();
	//		UserDetails bin = User.builder()
	//				.username("bin")
	//				.password("{noop}huyhoang123")
	//				.roles("EMPLOYEE", "MANAGER")
	//				.build();
	//		return new InMemoryUserDetailsManager(ducphan, skythien, bin);
	//	}
}


















