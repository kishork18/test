package com.masaischool.service;

import org.springframework.stereotype.Service;

import com.masaischool.entity.Customer;
import com.masaischool.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
