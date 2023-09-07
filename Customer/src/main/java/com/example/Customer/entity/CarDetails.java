package com.example.Customer.entity;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "CarDetails")
public class CarDetails {
	
	@Field(value = "Owner_Email")
	@Pattern(regexp = "[a-zA-Z0-9_]+@gmail.com" , message = "Invalid Email Format")
	String ownerEmail;
	
	@Field(value = "Car_Name")
	String carName;
	
	@Field(value = "Car_Type")
	String carType;
	
	@Id
	String carNumber;

	@Field(value = "Car_Colour")
	String carColour;

	public CarDetails(String ownerEmail, String carName, String carType, String carNumber, String carColour) {
		super();
		this.ownerEmail = ownerEmail;
		this.carName = carName;
		this.carType = carType;
		this.carNumber = carNumber;
		this.carColour = carColour;
	}

	public CarDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	
}
