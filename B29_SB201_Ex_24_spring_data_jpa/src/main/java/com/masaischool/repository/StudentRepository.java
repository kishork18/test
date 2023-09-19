package com.masaischool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masaischool.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByName(String name);	//SELECT s FROM Student s WHERE s.name = ?
	
	//SELECT s FROM Student s WHERE rollNo > ?1 AND marks < ?2
	List<Student> findByRollNoGreaterThanAndMarksLessThan(Integer rollNo, Double marks);
	
	@Query("SELECT s FROM Student s WHERE s.marks BETWEEN :start AND :end")	//named parameters
	List<Student> abc(@Param("start") Double start, @Param("end") Double end);
	
	@Query("SELECT s FROM Student s WHERE s.rollNo > ?1")	//positional parameters
	List<Student> pqr(Integer rollNo);
}
