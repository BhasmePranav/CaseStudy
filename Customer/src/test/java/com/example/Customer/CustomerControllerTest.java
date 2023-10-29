package com.example.Customer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.customer.controller.CustomerController;
import com.example.customer.entity.Customer;
import com.example.customer.serviceimplementation.CustomerServiceImpl;
import com.google.common.net.MediaType;

public class CustomerControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private CustomerServiceImpl customerServiceImpl;
	
	@InjectMocks
	private CustomerController customerController;
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.initMocks(this.customerController);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
//	@Test
//	public void testRegisterCustomer() throws Exception {
//        Customer customer = new Customer();
//        customer.setEmail("test@example.com");
//        customer.setFname("Test User");
//
//        when(customerServiceImpl.registerCustomer(any(Customer.class))).thenReturn(customer);
//
//        mockMvc.perform(post("/Customers/register")
//                .contentType(MediaType.JSON_UTF_8)
//                .content(asJsonString(customer)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.email").value("test@example.com"))
//                .andExpect(jsonPath("$.name").value("Test User"));
//    }

}
