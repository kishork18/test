package com.masaischool.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;

public class Customer {
	@NotNull(message = "Customer id must not be null")	//it Allow empty string and 0
	@Min(value = 1L, message = "id must be a +ive integer")	//is same as
	//@Positive(message = "id must be a +ive integer")
	private Integer id;
	
	//@NotEmpty(message = "you must provide the customer name")	//null, "": Not accept " ": accepted
	@NotBlank(message = "you must provide the customer name")	//null, "", " ": Not accept
	@Size(min = 2, message="name must be of 2 characters at least")
	private String name;
	
	@PastOrPresent(message = "Last purchase date must not be of future")
	private LocalDate lastPurchaseDate;
	
	@NotBlank(message = "you must provide the customer email")	//null, "", " ": Not accept
	@Pattern(regexp = "[a-z0-9.]+@[a-z0-9.]+\\\\.[a-z] {2,3}", flags = Flag.CASE_INSENSITIVE,
			message="Invaid email id")
	private String email;
	
	@NotBlank(message = "you must provide the customer mobile number")	//null, "", " ": Not accept
	@Pattern(regexp = "[6-9][0-9]{9}", message="Invaid mobile number")
	private String mobile;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id, String name, LocalDate lastPurchaseDate, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.lastPurchaseDate = lastPurchaseDate;
		this.email = email;
		this.mobile = mobile;
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
	
	public LocalDate getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
