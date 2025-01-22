/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop;

import com.ducpq.demo.aop.dao.AccountDAO;
import com.ducpq.demo.aop.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method for account DAO
		accountDAO.addAccount();
		
		// call the accountDAO getter/setter methods
		accountDAO.setName("John");
		accountDAO.getName();
		accountDAO.setServiceCode("ABC123");
		accountDAO.getServiceCode();
		
		// call the business method for membership DAO
		membershipDAO.addAccount();
		
		membershipDAO.addRole(true);
	}
	
	
}
