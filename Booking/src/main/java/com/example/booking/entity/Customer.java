package com.example.booking.entity;




public class Customer {

	private String fname;
	
	private String email;
	
	private String phoneNo;
	
	private String password;

	public Customer(String fname,  String email, String phoneNo , String password) {
		super();
		this.fname = fname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}



	public Customer() {
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
