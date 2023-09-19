package com.masaischool.B29_SB201_Ex_26_logging_example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/lombok")
@Slf4j
public class LoggingWithLombokController {
	
	@GetMapping("/logging")
	public ResponseEntity<String> logMessages(){
		log.error("This is log message for error level");
		log.warn("This is log message for warn level");
		log.info("This is log message for info level");
		log.debug("This is log message for debug level");
		log.trace("This is log message for trace level");
		
		return new ResponseEntity<String>("Hellow World!", HttpStatus.OK);
	}
	//http://localhost:8080/lombok/logging
}
