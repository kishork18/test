package com.masaischool.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Student;

import jakarta.annotation.PostConstruct;

@RestController
public class HelloController {
	Logger logger = LoggerFactory.getLogger("HelloController.class");
	List<Student> list;
	
	@PostConstruct
	public void populate() {
		list = new ArrayList<>();
		list.add(new Student(1, "ABC"));
	}
	
	@GetMapping("/get/{roll}")
	public ResponseEntity<Student> getRequest(@PathVariable Integer roll){
	    logger.info("Inside the getRequest");
	    Student student = list.stream().filter(st -> st.getRoll() == roll).toList().get(0);
	    return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PutMapping("/put/{roll}/{newname}")
	public ResponseEntity<Student> putRequest(@PathVariable Integer roll, @PathVariable String newname){
	    logger.info("Inside the putRequest");
	    Student student = list.stream().filter(st -> st.getRoll() == roll).toList().get(0);
	    student.setName(newname);
	    return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}