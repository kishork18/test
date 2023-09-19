package com.masaischool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masaischool.entity.Student;
import com.masaischool.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;
	
	//@Autowire
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		//call the service method to save Student object
		Student st = studentService.addStudent(student);
		return new ResponseEntity<Student>(st, HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> viewAllStudent() {
		//call the service method to get all Students
		List<Student> studentList = studentService.viewAllStudent();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	@GetMapping("/students/{rollNo}")
	public ResponseEntity<Student> viewStudentByRoll(@PathVariable Integer rollNo) {
		//call the service method to get Student by rollNo
		Student st= studentService.viewStudentByRollNo(rollNo);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		//call the service method to update Student object
		Student st = studentService.updateStudent(student);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{rollNo}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer rollNo) {
		//call the service method to update Student object
		Student st = studentService.deleteStudent(rollNo);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@GetMapping("/students_by_name/{name}")
	public ResponseEntity<Student> viewStudentByName(@PathVariable String name) {
		//call the service method to get Student by name
		Student st= studentService.viewStudentByName(name);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@GetMapping("/students_by_rollno_and_marks/{rollNo}/{marks}")
	public ResponseEntity<List<Student>> viewStudentByRollNoAndMarks(@PathVariable Integer rollNo, @PathVariable Double marks) {
		//call the service method to get Student by name
		List<Student> studentList = studentService.viewStudentByRollNoAndMarks(rollNo, marks);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	@GetMapping("/students_by_marks_range/{start}/{end}")
	public ResponseEntity<List<Student>> viewStudentByMarksRange(@PathVariable Double start, @PathVariable Double end){
		return new ResponseEntity<>(studentService.viewStudentByMarksRange(start, end), HttpStatus.OK);
	}
	
	@GetMapping("/students_by_more_than_rollno/{rollNo}")
	public ResponseEntity<List<Student>> viewStudentByGreaterRollNo(@PathVariable Integer rollNo){
		return new ResponseEntity<>(studentService.viewStudentByGreaterRollNo(rollNo) , HttpStatus.OK);
	}
}
