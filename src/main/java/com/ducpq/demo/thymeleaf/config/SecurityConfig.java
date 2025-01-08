package com.ducpq.demo.thymeleaf.config;

import com.ducpq.demo.thymeleaf.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	//	@Bean
	//	public InMemoryUserDetailsManager userDetailsManager() {
	//		UserDetails ducphan = User.builder().username("ducphan")
	//				.password("{noop}test123")
	//				.roles("EMPLOYEE").build();
	//		UserDetails bin = User.builder().username("bin")
	//				.password("{noop}test123")
	//				.roles("EMPLOYEE", "MANAGER").build();
	//		UserDetails thiensky = User.builder().username("thiensky")
	//				.password("{noop}test123")
	//				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
	//		return new InMemoryUserDetailsManager(ducphan, bin, thiensky);
	//	}
	
	//	@Bean
	//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
	//		return new JdbcUserDetailsManager(dataSource);
	//	}
	
	//	@Bean
	//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
	//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
	//		jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, isActive from user where username = ?");
	//
	//
	//	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(UserService userService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
						configurer
								// Spring Security secure all links so we have to add this ro prevent
								// static files to be prevented
								.requestMatchers("/css/**").permitAll()
								.requestMatchers("/js/**").permitAll()
								.requestMatchers("/images/**").permitAll()
								.requestMatchers("/fonts/**").permitAll()
								.requestMatchers("/").hasRole("EMPLOYEE")
								.requestMatchers("/leaders/**").hasRole("MANAGER")
								.requestMatchers("/admins/**").hasRole("ADMIN")
								.anyRequest().authenticated()
				)
				.exceptionHandling(configurer ->
						configurer.accessDeniedPage("/access-denied"))
				.formLogin(form ->
						form
								.loginPage("/login")
								.loginProcessingUrl("/authenticateTheUser") // no Controller Request Mapping required for this
								.permitAll())
				.logout(logout -> logout.permitAll()); // add logout support for default URL /logout
		return http.build();
	}
}
