package com.masaischool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masaischool.model.Student;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestTemplateController {
	@GetMapping("/get_student_by_roll_no/{rollNo}")
	public ResponseEntity<Student> getStudentByRollNo(@PathVariable Integer rollNo){
		String url = "http://localhost:8080/student/students/" + rollNo;
		RestTemplate template = new RestTemplate();
		return template.getForEntity(url, Student.class);
	}
	//http://localhost:9090/get_student_by_roll_no/
	
	@PostMapping("/add_student_resttemplate")
	public ResponseEntity<Student> addStudentByRestTemplate(@RequestBody Student student){
		String url = "http://localhost:8080/student/students";
		RestTemplate template = new RestTemplate();
		return template.postForEntity(url, student, Student.class);
	}
	//http://localhost:9090/add_student_resttemplate
}
