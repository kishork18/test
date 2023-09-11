package com.masai.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {
	
	@NotNull(message = "userId can't be null")
	@Min(value = 1L, message = "id should be a positive integer")
	private int userId;
	
	@NotBlank(message = "name can't be blank/null")
	private String name;
	
	@NotBlank(message = "email must be there")
	private String email;
	
	public User() {}
		
	public User(int userId, String name, String email) {
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
