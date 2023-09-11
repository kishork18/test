package com.masaischool.B29_SB201_Ex_20_First_Web_Application.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController	//same as @Controller + @ResponseBody
public class HelloController {
	//this method will be called for URL
	//http://localhost:8080/hello is same as
	//http://127.0.0.1:8080/hello
	//@RequestMapping("/")	//is same as
	//@RequestMapping(value = "/")	//is same as
	//@RequestMapping(method = RequestMethod.GET, value = "/hello")
	//@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = {"application/json"})
	//@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/hello")
	public String getMessage() {
		return "Hello_Masai";
	}
	
	//8080: port number. A port number of used to identify a service in the server
	//A port number is an unsigned int value that can be any from 0 - 65535
	//IANA: Internet Assigned Number Authority which actually regulate these port number
}
