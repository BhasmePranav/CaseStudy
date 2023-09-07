package com.example.Customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Customer.entity.Customer;
import com.example.Customer.exception.InvalidUserDetailsException;
import com.example.Customer.serviceImplementation.CustomerServiceImpl;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceimpl;
	
	
	@PostMapping("/register")
	private Customer registerCustomer(@RequestBody Customer customer) throws InvalidUserDetailsException
	{
		return customerServiceimpl.registerCustomer(customer);
		
	}
	
	@PutMapping("/update")
	private Customer updateCustomer(@RequestBody Customer customer) throws InvalidUserDetailsException
	{ 
		String email = customer.getEmail();
		return customerServiceimpl.updateCustomer(email , customer);
		
	}
	
	@DeleteMapping("/delete/{email}")
	private String deleteCustomer(@PathVariable String email) throws InvalidUserDetailsException
	{
		return customerServiceimpl.deleteCustomer(email);
	}
	
	@GetMapping("/allCustomers")
	private List<Customer> displayAllCustomers()
	{
		return customerServiceimpl.displayAllCustomers();
		
	}
	
	@GetMapping("/byEmail/{email}s")
	private Customer getByEmail(@PathVariable String email)
	{
		return customerServiceimpl.getByEmail(email);
		
	}

}
