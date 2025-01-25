/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop;

import com.ducpq.demo.aop.dao.AccountDAO;
import com.ducpq.demo.aop.dao.MembershipDAO;
import com.ducpq.demo.aop.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class AOPApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(AOPApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheAfterReturningAdvice(accountDAO);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method for account DAO
		accountDAO.addAccount(new Account(), true);
		
		// call the accountDAO getter/setter methods
		accountDAO.setName("John");
		accountDAO.getName();
		accountDAO.setServiceCode("ABC123");
		accountDAO.getServiceCode();
		
		// call the business method for membership DAO
		membershipDAO.addAccount();
		
		membershipDAO.addRole(true);
	}
	
	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("\n");
		System.out.println("Found accounts: " + accounts);
		
	}
	
	
}
