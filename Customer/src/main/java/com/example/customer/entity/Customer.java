package com.example.customer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Customers")
public class Customer {

	@Field("Customer_FirstName")
	private String fname;
	
	@Id
	private String email;
	
	@Field("Customer_PhoneNo")
	private String phoneNo;
	
	private String password;
	

	public Customer() {
		super();
	}
	
	public Customer(String fname, String email, String phoneNo ,String password) {
		super();
		this.fname = fname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
