package com.example.customer.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.customer.entity.Customer;
import com.example.customer.exception.InvalidUserDetailsException;
@Service
public interface CustomerService {
	
	public Customer registerCustomer(Customer customer) throws InvalidUserDetailsException;
	
	public Customer updateCustomer(String email , Customer customer) throws InvalidUserDetailsException;
	
	public String deleteCustomer(String email) throws InvalidUserDetailsException;
	
	public List<Customer> displayAllCustomers();
	
	public Customer getByEmail(String email);
	
	public Customer loginCustomer(String email , String password) throws InvalidUserDetailsException;

	

}