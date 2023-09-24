package com.masaischool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Customer;
import com.masaischool.service.CustomerService;

@RestController
public class CustomerController {
	private CustomerService customerService;
	private PasswordEncoder passwordEncoder;
	
	public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder) {
		this.customerService = customerService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		String hashedPassword = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(hashedPassword);
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	@GetMapping("/logged-in-customer")
	public ResponseEntity<Customer> getLoggedInCustomer(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
}
