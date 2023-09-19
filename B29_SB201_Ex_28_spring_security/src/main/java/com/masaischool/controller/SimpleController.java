package com.masaischool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	@GetMapping("/welcome")
	public ResponseEntity<String> wlecome(){
		return new ResponseEntity<String>("This is welcome message by GET request", HttpStatus.OK);
	}
	//http://localhost:8080/welcome
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		return new ResponseEntity<String>("This is hello message by GET request", HttpStatus.OK);
	}
	//http://localhost:8080/hello
}
