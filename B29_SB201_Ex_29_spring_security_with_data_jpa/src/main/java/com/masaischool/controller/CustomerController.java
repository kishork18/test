package com.masaischool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Customer;
import com.masaischool.service.CustomerService;

@RestController
public class CustomerController {
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
}
