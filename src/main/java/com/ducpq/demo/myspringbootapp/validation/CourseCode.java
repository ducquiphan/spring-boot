package com.ducpq.demo.myspringbootapp.validation;

import com.ducpq.demo.myspringbootapp.validation.contraintvalidator.CourseCodeConstrainValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// define default course code
	String value() default "SCI";
	
	// define default error message
	String message() default "Course Code must start with SCI";
	
	// define default groups
	Class<?>[] groups() default {};
	
	// define defaults payload
	Class<? extends Payload>[] payload() default {};
	
}
