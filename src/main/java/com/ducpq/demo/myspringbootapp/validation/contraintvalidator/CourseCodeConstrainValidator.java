package com.ducpq.demo.myspringbootapp.validation.contraintvalidator;

import com.ducpq.demo.myspringbootapp.validation.CourseCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		this.coursePrefix = constraintAnnotation.value();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String theString, ConstraintValidatorContext context) {
		if (theString == null) {
			return true;
		} else {
			return theString.startsWith(this.coursePrefix);
		}
	}
}
