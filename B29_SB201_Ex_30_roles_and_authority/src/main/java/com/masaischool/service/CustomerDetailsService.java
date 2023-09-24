package com.masaischool.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masaischool.entity.Customer;
import com.masaischool.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {
	private CustomerRepository customerRepository;
	
	public CustomerDetailsService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername of CustomerDetailsService");
		Optional<Customer> customer = customerRepository.findByEmail(email);
		return customer.orElseThrow(() -> new UsernameNotFoundException("No user found for email " + email));
	}
}
