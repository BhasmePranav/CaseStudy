package com.example.washer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Admins")
public class Admin {
	
	@Field("Admin_Name")
	String fname;
	
	@Field("Admin_PhoneNo")
	String phoneNo;
	
	@Id
	@Field("Admin_Email")
	String email;
	
	@Field("Admin_Password")
	String password;

	public Admin(String fname, String phoneNo, String email, String password) {
		super();
		this.fname = fname;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
