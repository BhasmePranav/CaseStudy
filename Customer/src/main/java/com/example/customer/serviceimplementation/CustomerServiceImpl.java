package com.example.customer.serviceimplementation;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entity.Customer;
import com.example.customer.exception.InvalidUserDetailsException;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer registerCustomer(Customer customer) throws InvalidUserDetailsException {
		if(customer.getEmail().isEmpty())  throw new InvalidUserDetailsException("Email is Mandatory");
		else
		{
			if(customerRepository.findByEmail(customer.getEmail()).isPresent())  throw new InvalidUserDetailsException("Email is already registered.");
			else
			{
				Customer c1 = new Customer();
				c1.setFname(customer.getFname());
				c1.setEmail(customer.getEmail());
				c1.setPhoneNo(customer.getPhoneNo());
				c1.setPassword(customer.getPassword());
				return customerRepository.save(c1);
			}
		}
	}

	@Override
	public Customer updateCustomer(String email , Customer customer) throws InvalidUserDetailsException {
		Optional<Customer> customerPresent = customerRepository.findByEmail(email);
		if(customerPresent.isPresent())
		{
			Customer customerUpdate = customerPresent.get();
			customerUpdate.setFname(customer.getFname());
			customerUpdate.setPhoneNo(customer.getPhoneNo());
			customerUpdate.setPassword(customer.getPassword());
			return customerRepository.save(customerUpdate);
		}
		else {
			throw new InvalidUserDetailsException("Email Not registered , Please create new Account");
		}	
	}

	@Override
	public String deleteCustomer(String email) throws InvalidUserDetailsException {
		Optional<Customer> customerPresent = customerRepository.findByEmail(email);
		if(customerPresent.isPresent()) 
		{
			customerRepository.delete(customerPresent.get());
			return "Customer with "+email+" deleted.";
		} 
		else
		{
			throw new InvalidUserDetailsException("User not registered with this email.");
		}
	}

	@Override
	public List<Customer> displayAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getByEmail(String email) {
		Optional<Customer> customerPresent = customerRepository.findByEmail(email);
		if(customerPresent.isPresent())
		{
			return customerPresent.get();
		}
		return null;
	}

	@Override
	public Customer loginCustomer(String email, String password) throws InvalidUserDetailsException {
		Customer loginCustomer = customerRepository.findByEmail(email).orElseThrow(() -> new InvalidUserDetailsException("User not Found"));
		String loginPassword = loginCustomer.getPassword();
		if(password.equals(loginPassword)) {
			return loginCustomer;
		}
		else
		{
			throw new InvalidUserDetailsException("Invalid credentials");
		}
		
	}
	
	
	

}

