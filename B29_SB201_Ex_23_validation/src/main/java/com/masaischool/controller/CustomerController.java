package com.masaischool.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Customer;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
public class CustomerController {
	private List<Customer> customerList;
	
	public CustomerController() {
		customerList = new ArrayList<>();
	}
	
	@PostConstruct
	public void setCustomerDetails() {
		customerList.add(new Customer(1, "ABC", LocalDate.now(), "a@a.in", "9865321475"));
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		customerList.add(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
}