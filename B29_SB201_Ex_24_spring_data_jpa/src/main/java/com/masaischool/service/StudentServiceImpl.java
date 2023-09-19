package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masaischool.entity.Student;
import com.masaischool.exception.StudentNotFoundForRollNoException;
import com.masaischool.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	
	//@Autowire
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> viewAllStudent() {
		if(studentRepository.count() == 0) {
			throw new StudentNotFoundForRollNoException("No Student found");
		}
		return studentRepository.findAll();
	}

	@Override
	public Student viewStudentByRollNo(Integer rollNo) {
		Optional<Student> student = studentRepository.findById(rollNo);
		if(student.isPresent()) {
			//you are here means Student is available for the given roll number
			return student.get();
		}
		throw new StudentNotFoundForRollNoException("No Student found with roll no " + rollNo);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> st = studentRepository.findById(student.getRollNo());
		if(st.isPresent())
			return studentRepository.save(student);
		throw new StudentNotFoundForRollNoException("No Student found with roll no " + student.getRollNo());
	}

	@Override
	public Student deleteStudent(Integer rollNo) {
		Optional<Student> st = studentRepository.findById(rollNo);
		if(st.isPresent()) {
			studentRepository.deleteById(rollNo);
			return st.get();
		}

		throw new StudentNotFoundForRollNoException("No Student found with roll no " + rollNo);
	}
	
	public Student viewStudentByName(String name) {
		Optional<Student> student = studentRepository.findByName(name);
		if(student.isPresent()) {
			//you are here means Student is available for the given name
			return student.get();
		}
		throw new StudentNotFoundForRollNoException("No Student found with name " + name);
	}
	
	public List<Student> viewStudentByRollNoAndMarks(Integer rollNo, Double marks){
		return studentRepository.findByRollNoGreaterThanAndMarksLessThan(rollNo, marks);
	}
	
	public List<Student> viewStudentByMarksRange(Double start, Double end){
		return studentRepository.abc(start, end);
	}
	
	public List<Student> viewStudentByGreaterRollNo(Integer rollNo){
		return studentRepository.pqr(rollNo);
	}
}
