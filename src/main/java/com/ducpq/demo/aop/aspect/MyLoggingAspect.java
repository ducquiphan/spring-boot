/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.aspect;

import com.ducpq.demo.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MyLoggingAspect
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-17
 */
@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	// this is where we add all of our related advices for logging
	@Before("com.ducpq.demo.aop.expression.AopExpression.forDAOPackageNoGetterOrSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n==========>>> Executing @Before advice on any method");
		
		// display the method signature
		// Casting getSignature() to MethodSignature is done because MethodSignature
		// is a sub-interface of Signature that provides more specific information about the intercepted method. MethodSignature includes details
		// that are specific to methods, such as parameter types, return type, and thrown exceptions, which are not available in the Signature interface.
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method Signature: " + methodSignature);
		
		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			if (arg instanceof Account theAccount) {
				// downcasr and print Account specific stuff
				System.out.println("Account username: " + theAccount.getUsername());
				System.out.println("Account password: " + theAccount.getPassword());
				continue;
			}
			System.out.println("Argument: " + arg);
		}
	}
	
	@AfterReturning(pointcut = "execution(* com.ducpq.demo.aop.dao.AccountDAO.findAccounts(..))",
			returning = "accounts")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString(); // get the method from a class only, not a package
		System.out.println("\n==========>>> Executing @AfterReturning advice on method: " + method);
		// print out the result
		System.out.println("\n==========>>> The result is: " + accounts);
		
		// modify "result" list
		if (!accounts.isEmpty()) {
			accounts.stream().forEach(account -> account.setUsername(account.getUsername().toUpperCase()));
		}
	}
	
	@AfterThrowing(pointcut = "execution(* com.ducpq.demo.aop.dao.AccountDAO.findAccounts(..))",
			throwing = "exception")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
		// print out which method we are advising on
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("\n==========>>> Executing @AfterThrowing advice on method: " + methodSignature);
		
		System.out.println("The exception is: " + exception);
	}
	
	@After("execution(* com.ducpq.demo.aop.dao.AccountDAO.findAccounts(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("\n==========>>> Executing @After advice on method: " + methodSignature);
	}
	
	@Around("execution(* com.ducpq.demo.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
		// now, let's execute the method
		Object result = null;
		
		// get begin timestamp
		long begin = System.nanoTime();
		try {
			String signatureMethod = joinPoint.getSignature().toShortString();
			System.out.println("\n==========>>> Executing @Around advice on method: " + signatureMethod);
			result = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println("@Around advice We have a problem: " + e.getMessage());
			
			// rethrow exception
			throw e;
		}
		
		// get end timestamp
		long end = System.nanoTime();
		
		// compute duration and display it
		long duration = (end - begin) / 1000000;
		System.out.println("\n==========>>> The duration is: " + duration + " ms");
		
		return result;
	}
	
	
}
