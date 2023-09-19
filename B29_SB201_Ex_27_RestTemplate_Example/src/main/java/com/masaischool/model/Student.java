package com.masaischool.model;

public class Student {
	private Integer rollNo;
	private String name;
	private Double marks;
	public Student(Integer rollNo, String name, Double marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	
	public Student(String name, Double marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
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
