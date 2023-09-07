package com.example.Customer.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Customer.entity.Customer;
import com.example.Customer.exception.InvalidUserDetailsException;
import com.example.Customer.repository.CustomerRepository;
import com.example.Customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) throws InvalidUserDetailsException {
		// TODO Auto-generated method stub
		if(customer.getEmail().isEmpty())  throw new InvalidUserDetailsException("Email is Mandatory");
		else
		{
			if(customerRepository.findByEmail(customer.getEmail()).isPresent())  throw new InvalidUserDetailsException("Email is already registered.");
			else
			{
				Customer c1 = new Customer();
				c1.setFname(customer.getFname());
				c1.setLname(customer.getLname());
				c1.setEmail(customer.getEmail());
				c1.setPhoneNo(customer.getPhoneNo());
				return customerRepository.save(c1);
			}
		}
	}

	@Override
	public Customer updateCustomer(String email , Customer customer) throws InvalidUserDetailsException {
		// TODO Auto-generated method stub
		Optional<Customer> customerPresent = customerRepository.findByEmail(email);
		if(customerPresent.isPresent())
		{
			Customer customerUpdate = customerPresent.get();
			customerUpdate.setFname(customer.getFname());
			customerUpdate.setLname(customer.getLname());
			customerUpdate.setPhoneNo(customer.getPhoneNo());
			return customerRepository.save(customerUpdate);
		}
		else {
			throw new InvalidUserDetailsException("Email Not registered , Please create new Account");
		}	
	}

	@Override
	public String deleteCustomer(String email) throws InvalidUserDetailsException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<Customer> customerPresent = customerRepository.findByEmail(email);
		if(customerPresent.isPresent())
		{
			Customer c = customerPresent.get();
			return c;
		}
		return null;
	}

}

