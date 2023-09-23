package com.masaischool.lombok_demo;

import java.util.List;

public class Employee {
	private Integer id;
	private String name;
	private String state;
	private String salary;
	private List<String> hobbies;
	
	public Employee() {	//No argument constructor
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer id, String name, String state, String salary, List<String> hobbies) {
		//All arguments constructors
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.salary = salary;
		this.hobbies = hobbies;
	}
	
	//getter and setter methods
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	//toString method with fields name, state and salary
	@Override
	public String toString() {
		return "Employee [name=" + name + ", state=" + state + ", salary=" + salary + "]";
	}
	
	//hashCode & equals
	//for id & hobbies
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
