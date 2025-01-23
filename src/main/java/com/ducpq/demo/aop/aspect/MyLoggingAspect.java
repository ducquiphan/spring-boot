/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.aspect;

import com.ducpq.demo.aop.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
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
	
	
}
