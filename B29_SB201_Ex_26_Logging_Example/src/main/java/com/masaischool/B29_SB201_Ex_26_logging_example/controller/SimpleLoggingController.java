package com.masaischool.B29_SB201_Ex_26_logging_example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleLoggingController {
	
	//step-01: get the object for log messages for current class
	Logger logger = LoggerFactory.getLogger(SimpleLoggingController.class);
	
	@GetMapping("/log_messages")
	public ResponseEntity<String> logMessages(){
		logger.error("This is log message for error level");
		logger.warn("This is log message for warn level");
		logger.info("This is log message for info level");
		logger.debug("This is log message for debug level");
		logger.trace("This is log message for trace level");
		
		return new ResponseEntity<String>("Hellow World!", HttpStatus.OK);
	}
	//http://localhost:8080/simple/log_messages
}
