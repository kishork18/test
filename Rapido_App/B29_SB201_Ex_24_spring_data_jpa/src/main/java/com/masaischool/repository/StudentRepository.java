package com.masaischool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.masaischool.dto.StudentDTO;
import com.masaischool.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByName(String name);	//SELECT s FROM Student s WHERE s.name = ?
	
	//SELECT s FROM Student s WHERE rollNo > ?1 AND marks < ?2
	List<Student> findByRollNoGreaterThanAndMarksLessThan(Integer rollNo, Double marks);
	
	@Query("SELECT s FROM Student s WHERE s.marks BETWEEN :start AND :end")	//named parameters
	List<Student> abc(@Param("start") Double start, @Param("end") Double end);
	
	@Query("SELECT s FROM Student s WHERE s.rollNo > ?1")	//positional parameters
	List<Student> pqr(Integer rollNo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM st")
	List<Student> xyz();
	
	@Query("SELECT new com.masaischool.dto.StudentDTO(s.name, s.marks) FROM Student s")
	List<StudentDTO> getNameAndMarks();
	
	@Transactional
	@Modifying
	@Query("UPDATE Student s SET s.name = :name WHERE s.rollNo = :rollNo")
	Integer updateName(@Param("name") String name, @Param("rollNo") Integer rollNo);
	
	List<Student> findTop2ByMarksGreaterThan(Double marks);	//SELECT * FROM st WHERE marks > ? LIMIT 0,2
	List<Student> findTop3ByOrderByNameDesc();	//SELECT * FROM st ORDER BY Name Desc LIMIT 0,3
	
}
