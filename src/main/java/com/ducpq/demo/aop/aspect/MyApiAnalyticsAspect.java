/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
@Order(3)
public class MyApiAnalyticsAspect {
	// this is where we add all of our related advices for logging
	@Before("com.ducpq.demo.aop.expression.AopExpression.forDAOPackageNoGetterOrSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n==========>>> Executing API Analytics on com.ducpq.demo.aop.dao.*.add*(..)");
	}
	
}
