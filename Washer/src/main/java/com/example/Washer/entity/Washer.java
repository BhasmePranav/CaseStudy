package com.example.Washer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Washers")
public class Washer {

	@Field("Washer_Id")
	Integer id;
	
	@Field("Washer_Name")
	String name;
	
	@Id
	@Field("Washer_Email")
	String email;
	
	@Field("Washer_PhoneNo")
	String PhoneNo;

	public Washer(Integer id, String name, String email, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		PhoneNo = phoneNo;
	}

	public Washer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	
	
	
	

}
