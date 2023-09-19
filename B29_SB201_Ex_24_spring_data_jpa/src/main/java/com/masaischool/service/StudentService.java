package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Student;

public interface StudentService {
	public Student addStudent(Student student);
	public List<Student> viewAllStudent();
	public Student viewStudentByRollNo(Integer rollNo);
	public Student updateStudent(Student student);
	public Student deleteStudent(Integer rollNo);
	
	public Student viewStudentByName(String name);
	public List<Student> viewStudentByRollNoAndMarks(Integer rollNo, Double marks);
	
	public List<Student> viewStudentByMarksRange(Double start, Double end);
	public List<Student> viewStudentByGreaterRollNo(Integer rollNo);
	
}
