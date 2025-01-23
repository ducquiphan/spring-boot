/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.expression;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * AopExpression
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-23
 */
@Aspect // @Aspect is optional for Class contains only Pointcuts
public class AopExpression {
	// Creating a pointcut declaration
	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.*(..))")
	public void forDAOPackage() {
	}
	
	//	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.get*(..))")
	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.get*(..))")
	public void forDAOPackageGetter() {
	}
	
	@Pointcut("execution(* com.ducpq.demo.aop.dao.*.set*(..))")
	public void forDAOPackageSetter() {
	}
	
	// Combining pointcut
	@Pointcut("forDAOPackage() && !(forDAOPackageGetter() || forDAOPackageSetter())")
	public void forDAOPackageNoGetterOrSetter() {
	}
}
