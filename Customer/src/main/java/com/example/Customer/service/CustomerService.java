package com.example.Customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Customer.entity.Customer;
import com.example.Customer.exception.InvalidUserDetailsException;
@Service
public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws InvalidUserDetailsException;
	
	public Customer updateCustomer(String email , Customer customer) throws InvalidUserDetailsException;
	
	public String deleteCustomer(String email) throws InvalidUserDetailsException;
	
	public List<Customer> displayAllCustomers();
	
	public Customer getByEmail(String email);
	

}