package com.masaischool.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Customer;
import com.masaischool.entity.RolesAndAuthority;
import com.masaischool.service.CustomerService;
import com.masaischool.service.RolesAndAuthorityService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	private CustomerService customerService;
	private PasswordEncoder passwordEncoder;
	private RolesAndAuthorityService rolesAndAuthorityService; 
	
	public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder, RolesAndAuthorityService rolesAndAuthorityService) {
		this.customerService = customerService;
		this.passwordEncoder = passwordEncoder;
		this.rolesAndAuthorityService = rolesAndAuthorityService;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		//password encoding part
		String hashedPassword = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(hashedPassword);
		
		//Associate customer to the roles and authorities
		Set<RolesAndAuthority> authoritiesSet = customer.getAuthoritiesSet();	//objects has only name
		
		Set<RolesAndAuthority> authoritiesSetManaged = new HashSet<>();	//objects has only name & id
		for(RolesAndAuthority roles: authoritiesSet) {
			authoritiesSetManaged.add(rolesAndAuthorityService.getRolesAndAuthority(roles.getName()));
		}
		
		customer.setAuthoritiesSet(authoritiesSetManaged);
		
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	@GetMapping("/logged-in-customer")
	public ResponseEntity<Customer> getLoggedInCustomer(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@GetMapping("/for-admin-only")
	public ResponseEntity<String> getDetailsForAdmin(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<String>("This is for admin, your role is " + customer.getAuthoritiesSet(), HttpStatus.OK);
	}
	
	@GetMapping("/for-user-and-guest-only")
	public ResponseEntity<String> getDetailsForAdminGuest(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<String>("This is for either admin or guest, you are " + customer.getAuthoritiesSet(), HttpStatus.OK);
	}
	
	@GetMapping("/for-user-only")
	public ResponseEntity<String> getDetailsForUser(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<String>("This is for user, your role is " + customer.getAuthoritiesSet(), HttpStatus.OK);
	}
	
	@GetMapping("/for-can-update")
	public ResponseEntity<String> getDetailsWhoUpdate(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<String>("This is for user, your authority is " + customer.getAuthoritiesSet(), HttpStatus.OK);
	}
	
	@GetMapping("/for-can-read-or-write")
	public ResponseEntity<String> getDetailsWhoReadOrWrite(){
		Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<String>("This is for user, your authority is " + customer.getAuthoritiesSet(), HttpStatus.OK);
	}
}
