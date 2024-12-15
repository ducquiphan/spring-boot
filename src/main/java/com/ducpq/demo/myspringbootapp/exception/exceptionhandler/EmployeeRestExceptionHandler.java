package com.ducpq.demo.myspringbootapp.exception.exceptionhandler;

import com.ducpq.demo.myspringbootapp.exception.EmployeeNotFoundException;
import com.ducpq.demo.myspringbootapp.exception.RequiredFieldsNotMeetException;
import com.ducpq.demo.myspringbootapp.respmessage.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(EmployeeNotFoundException e) {
		ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(RequiredFieldsNotMeetException e) {
		ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	// add another exception handler... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(Exception e) {
		ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
