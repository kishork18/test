package com.masaischool.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employeeList;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", employeeList=" + employeeList
				+ "]";
	}
}
