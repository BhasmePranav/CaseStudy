package com.example.Customer;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.customer.entity.Customer;
import com.example.customer.exception.InvalidUserDetailsException;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.serviceimplementation.CustomerServiceImpl;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
 class CustomerTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	
	@BeforeEach
    void setUp() {
        
		this.customerServiceImpl = new CustomerServiceImpl(this.customerRepository);
    }
	
	
	  @Test
	    void testRegisterCustomerValid() throws InvalidUserDetailsException {
	       
		  Customer customer = new Customer();
		  customer.setEmail("albert@gmail.com");
		  customer.setFname("Albert");
		  customer.setPhoneNo("8877669955");
		  
		  customerServiceImpl.registerCustomer(customer);
		  Customer c = customerRepository.save(customer);
		  Customer regCustomer = customerRepository.findById("albert@gmail.com").orElse(null);
		  assertEquals(regCustomer, c);
	    }
	  
	  @Test
	  void testUpdateCustomer() throws InvalidUserDetailsException
	  {
	       String email = "test@example.com";

	        
	        Customer updatedCustomer = new Customer();
	        updatedCustomer.setFname("John");
	        updatedCustomer.setPhoneNo("1234567890");

	        Customer initialCustomer = new Customer();
	        initialCustomer.setFname("Jane");
	        initialCustomer.setPhoneNo("9876543210");

	        
	        when(customerRepository.findByEmail(email)).thenReturn(Optional.of(initialCustomer));
	        when(customerRepository.save(initialCustomer)).thenReturn(updatedCustomer);

	     
	        Customer result = customerServiceImpl.updateCustomer(email, updatedCustomer);


	        assertNotNull(result);
	        assertEquals("John", result.getFname());
	        assertEquals("1234567890", result.getPhoneNo());
	    
	  }
	  
	  @Test
	  void deleteCustomer() throws InvalidUserDetailsException
	  {
		  String email = "test@example.com";

	       
	        Customer customerToDelete = new Customer();
	        customerToDelete.setEmail(email);

	        
	        when(customerRepository.findByEmail(email)).thenReturn(Optional.of(customerToDelete));

	  
	        String result = customerServiceImpl.deleteCustomer(email);


	        assertNotNull(result);
	        assertEquals("Customer with test@example.com deleted.", result);
	        verify(customerRepository, times(1)).delete(customerToDelete);

	  }

	@Test
	void getAllCustomers()
	{
		customerServiceImpl.displayAllCustomers();
		verify(customerRepository).findAll();
	}
	
	@Test
	void testCustmoerByEmail()
	{
		String email = "test@example.com";

        
        Customer expectedCustomer = new Customer();
        expectedCustomer.setEmail(email);
        when(customerRepository.findByEmail(email)).thenReturn(Optional.of(expectedCustomer));

        Customer result = customerServiceImpl.getByEmail(email);
   
        assertNotNull(result);
        assertEquals(expectedCustomer.getEmail(), result.getEmail());
	}

	
}

