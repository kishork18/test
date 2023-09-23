package com.masaischool.dto;

public class StudentDTO {
	private String name;
	private Double marks;
	
	public StudentDTO(String name, Double marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}	
}
