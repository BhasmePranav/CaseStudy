package com.example.washer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Washers")
public class Washer {

	@Field("Washer_Name")
	String fname;
	
	@Id
	@Field("Washer_Email")
	String email;
	
	@Field("Washer_PhoneNo")
	String phoneNo;
	
	@Field("Password")
	String password;

	public Washer(String fname, String email, String phoneNo , String password) {
		super();
		
		this.fname = fname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public Washer() {
		super();
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
