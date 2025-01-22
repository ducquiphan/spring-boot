/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	// Creating a pointcut declaration
	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.*(..))")
	private void forDAOPackage() {
	}
	
	//	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.get*(..))")
	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.get*(..))")
	private void forDAOPackageGetter() {
	}
	
	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.set*(..))")
	private void forDAOPackageSetter() {
	}
	
	// Combining pointcut
	@Pointcut("forDAOPackage() && !(forDAOPackageGetter() || forDAOPackageSetter())")
	private void forDAOPackageNoGetterOrSetter() {
	}
	
	// this is where we add all of our related advices for logging
	
	// @Before advice
	//	@Before("execution(public void updateAccount())")
	//	public void beforeUpdateAccountAdvice() {
	//		System.out.println("\n==========>>> Executing @Before advice on updateAccount()");
	//	}
	
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
	//	@Before("execution(* com.ducpq.demo.aop.dao.*.add*(boolean))")
	//	public void beforeAddAdviceWildcardParam() {
	//		System.out.println("\n==========>>> Executing @Before advice on add*(boolean)");
	//	}
	
	//	@Before("forDAOPackage()")
	//	public void beforeAddAdviceWildcardParamAny() {
	//		System.out.println("\n==========>>> Executing @Before advice on com.ducpq.demo.aop.dao.*.add*(..)");
	//	}
	
	//	@Before("forDAOPackage()")
	//	public void performAPIAnalytics() {
	//		System.out.println("\n==========>>> Executing API Analytics on com.ducpq.demo.aop.dao.*.add*(..)");
	//	}
	
	@Before("forDAOPackageNoGetterOrSetter()")
	public void performAllMethodButGetterAndSetter() {
		System.out.println("\n==========>>> Executing methods except getter and setter on com.ducpq.demo.aop.dao.*");
	}
}
