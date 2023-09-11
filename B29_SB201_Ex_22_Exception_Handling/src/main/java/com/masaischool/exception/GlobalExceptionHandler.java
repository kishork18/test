package com.masaischool.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {	//this is a single point to handle exception for whole application
	@ExceptionHandler(StudentNotFoundForRollNoException.class)
	public ResponseEntity<ErrorDetails> handleException(StudentNotFoundForRollNoException ex, WebRequest request){
		//Create an object of ErrorDetails
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> handleException404(NoHandlerFoundException ex, WebRequest request){
		//Create an object of ErrorDetails
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
}
