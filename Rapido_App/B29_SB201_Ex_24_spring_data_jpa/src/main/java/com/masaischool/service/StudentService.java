package com.masaischool.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.masaischool.dto.StudentDTO;
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
	
	public List<Student> viewStudentByNativeQuery();
	
	public List<StudentDTO> findNameAndMarks();
	public Integer updateName(String name, Integer rollNo);
	
	public List<Student> findTop2ForMarks(Double marks);
	
	public List<Student> findTop3ByNameDesc();
	
	public List<Student> getStudentsSorted(String fieldOne, String dirOne,  String fieldTwo, String dirTwo);
	
	public List<Student> getStudentsPageWise(Integer pageNo, Integer recordsPerPage);
}
