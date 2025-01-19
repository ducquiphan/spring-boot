/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * MyLoggingAspect
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-17
 */
@Aspect
@Component
public class MyLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// @Before advice
	@Before("execution(public void updateAccount())")
	public void beforeUpdateAccountAdvice() {
		System.out.println("\n==========>>> Executing @Before advice on updateAccount()");
	}
	
	//	@Before("execution(public void addAccount())")
	//	public void beforeAddAccountAdvice() {
	//		System.out.println("\n==========>>> Executing @Before advice on addAccount()");
	//	}
	
	//	@Before("execution(public void com.ducpq.demo.aop.dao.AccountDAO.addAccount())")
	//	public void beforeAccountDAOAddAccountAdvice() {
	//		System.out.println("\n==========>>> Executing @Before advice on AccountDAO.addAccount()");
	//	}
	
	//	@Before("execution(public void add*())")
	//	@Before("execution(* add*())")
	//	public void beforeAddAdviceWildcard() {
	//		System.out.println("\n==========>>> Executing @Before advice on add*()");
	//	}
	
	//	@Before("execution(* add*(boolean))")
	//	public void beforeAddAdviceWildcardParam() {
	//		System.out.println("\n==========>>> Executing @Before advice on add*(boolean)");
	//	}
	
	@Before("execution(* com.ducpq.demo.aop.dao.*.add*(..))")
	public void beforeAddAdviceWildcardParamAny() {
		System.out.println("\n==========>>> Executing @Before advice on com.ducpq.demo.aop.dao.*.add*(..)");
	}
	
}
