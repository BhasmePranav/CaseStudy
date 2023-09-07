package com.example.Customer.entity;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.processing.Generated;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

@Document(collection = "Customers")
public class Customer {

	@Field("Customer_Id")
	@Indexed(unique = true)
	private Integer id;
	
	@NonNull
	@Field("Customer_FirstName")
	private String fname;
	
	@NonNull
	@Field("Customer_LastName")
	private String lname;
	
	@Id
	@Pattern(regexp = "[a-zA-Z0-9_]+@gmail.com" , message = "Invalid Email Format")
	private String email;
	
	@Field("Customer_PhoneNo")
	private String phoneNo;
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Integer id, String fname, String lname, String email, String phoneNo) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phoneNo = phoneNo;
	}


	@Transient
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
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
	
	
	@Transient
	private static final AtomicLong counter = new AtomicLong();
	public Integer generateId()
	{
		Integer generatedId = (int) counter.getAndIncrement();
		
		return generatedId;
	}
	
	
	
	
}
