package com.example.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Customer;
import com.example.customer.exception.InvalidUserDetailsException;
import com.example.customer.serviceimplementation.CustomerServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceimpl;
	
	
	@PostMapping("/register")
	Customer registerCustomer(@RequestBody Customer customer) throws InvalidUserDetailsException
	{
		return customerServiceimpl.registerCustomer(customer);
		
	}
	
	@PutMapping("/update")
	Customer updateCustomer(@RequestBody Customer customer) throws InvalidUserDetailsException
	{ 
		String email = customer.getEmail();
		return customerServiceimpl.updateCustomer(email , customer);
		
	}
	
	@DeleteMapping("/delete/{email}")
	String deleteCustomer(@PathVariable String email) throws InvalidUserDetailsException
	{
		return customerServiceimpl.deleteCustomer(email);
	}
	
	@GetMapping("/allCustomers")
	List<Customer> displayAllCustomers()
	{
		return customerServiceimpl.displayAllCustomers();
		
	}
	
	@GetMapping("/byEmail/{email}")
	Customer getByEmail(@PathVariable String email)
	{
		return customerServiceimpl.getByEmail(email);
		
	}
	
	@GetMapping("/loginCustomer/{email}/{password}")
	public Customer loginCustomer(@PathVariable String email, @PathVariable String password) throws InvalidUserDetailsException {
		
		return customerServiceimpl.loginCustomer(email, password);
		
	}
	
	

}
