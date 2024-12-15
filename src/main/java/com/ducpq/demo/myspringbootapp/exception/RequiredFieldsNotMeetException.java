package com.ducpq.demo.myspringbootapp.exception;

public class RequiredFieldsNotMeetException extends RuntimeException {
	public RequiredFieldsNotMeetException(String message) {
		super(message);
	}
	
	public RequiredFieldsNotMeetException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RequiredFieldsNotMeetException(Throwable cause) {
		super(cause);
	}
}
