package com.masaischool.lombok_demo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeWithLombok {
	@ToString.Exclude
	private Integer id;
	
	@EqualsAndHashCode.Exclude
	private String name;
	@EqualsAndHashCode.Exclude
	private String state;
	@EqualsAndHashCode.Exclude
	private String salary;
	
	@ToString.Exclude
	private List<String> hobbies;
}
