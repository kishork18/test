package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DuplicateValueException.class)
	public ResponseEntity<ErrorDetails> duplicateValueExceptionHandler (DuplicateValueException dve) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), dve.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException .class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler (MethodArgumentNotValidException manv) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), manv.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler (UserNotFoundException unf) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), unf.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
}
