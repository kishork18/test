package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
