package com.ducpq.demo.myspringbootapp.exception.exceptionhandler;

import com.ducpq.demo.myspringbootapp.exception.StudentNotFoundException;
import com.ducpq.demo.myspringbootapp.responsemessage.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(StudentNotFoundException e) {
		ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<ResponseMessage> handleException(Exception e) {
		ResponseMessage error = new ResponseMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
