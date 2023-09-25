package com.masaischool.model;

public class Student {
	  private Integer roll;
	  private String name;
	  
	  public Student() {
	    super();
	  }

	  public Student(Integer roll, String name) {
	    this.roll = roll;
	    this.name = name;
	  }

	  public Integer getRoll() {
	    return roll;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setRoll(Integer roll) {
	    this.roll = roll;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }
}
