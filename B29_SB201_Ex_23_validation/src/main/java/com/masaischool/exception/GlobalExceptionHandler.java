package com.masaischool.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleInvalidMethodArguments(MethodArgumentNotValidException ex){
		List<ObjectError> allErrors = ex.getAllErrors();
		List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);
		String message = String.join(", ", errorsToStringList);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}