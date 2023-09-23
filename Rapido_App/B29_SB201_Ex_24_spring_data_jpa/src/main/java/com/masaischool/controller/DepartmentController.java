package com.masaischool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Department;
import com.masaischool.entity.Employee;
import com.masaischool.service.DepartmentService;

@RestController	
@RequestMapping(path = "/department")
//this controller will work for all URL http://localhost:8080/department/*.
public class DepartmentController {
	private DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService){
		this.departmentService = departmentService;
	}
	
	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		//First we have to assign department to the employee
		List<Employee> employeeList = department.getEmployeeList();
		for(Employee emp: employeeList)
			emp.setDepartment(department);
		
		Department dept = departmentService.addDepartment(department);
		return new ResponseEntity<Department>(dept, HttpStatus.CREATED);
	}
}

//use following data
//{
//	"name": "ABC",
//	"location": "Jaipur",
//	"employeeList": [
//		{
//			"name": "XUZ",
//			"dob": "15/09/1992",
//			"address": {
//				"city": "Jaipur",
//				"state": "Rajasthan",
//				"zipCode": "302002"
//			}
//		},
//		{
//			"name": "YUT",
//			"dob": "16/09/1991",
//			"address": {
//				"city": "Sikar",
//				"state": "Rajasthan",
//				"zipCode": "305021"
//			}
//		}
//	]	
//}
