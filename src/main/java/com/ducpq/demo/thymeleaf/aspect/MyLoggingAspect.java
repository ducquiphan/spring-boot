/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.thymeleaf.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * MyLoggingAspect
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-26
 */
@Aspect
@Component
public class MyLoggingAspect {
	// setup logger
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.ducpq.demo.thymeleaf.controller.*.*(..))")
	public void controllerPackage() {
	}
	
	@Pointcut("execution(* com.ducpq.demo.thymeleaf.service.*.*(..))")
	public void servicePackage() {
	}
	
	@Pointcut("execution(* com.ducpq.demo.thymeleaf.repository.*.*(..))")
	public void repoPackage() {
	}
	
	@Pointcut("controllerPackage() || servicePackage() || repoPackage()")
	public void forAppFlow() {
	}
	
	@Before("forAppFlow()")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("=============> @Before execution, method name: " + joinPoint.getSignature());
		
		Object[] args = joinPoint.getArgs();
		
		Arrays.stream(args).forEach(arg -> logger.info("=============> Argument: " + arg));
	}
	
	@AfterReturning(pointcut = "forAppFlow()",
			returning = "returnValue")
	public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
		logger.info("=============> @AfterReturning execution, method name: " + joinPoint.getSignature());
		
		logger.info("=============> Return value: " + returnValue);
	}
}
