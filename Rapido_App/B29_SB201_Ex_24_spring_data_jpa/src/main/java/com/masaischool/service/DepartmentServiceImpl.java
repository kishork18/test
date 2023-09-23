package com.masaischool.service;

import org.springframework.stereotype.Service;

import com.masaischool.entity.Department;
import com.masaischool.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository){
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

}
