/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop;

import com.ducpq.demo.aop.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AOPApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(AOPApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		// call the business method
		accountDAO.addAccount();
		
		// do it again!
		System.out.println("\nLet's call it again");
		
		// call the business method again
		accountDAO.addAccount();
	}
	
	
}
