package com.example.booking.entity;


public class Car {
	
	
	String ownerEmail;
	
	String carName;
	
	String carType;
	
	String carNumber;
	
	String carColor;

	public Car() {
		super();

	}

	public Car(String ownerEmail, String carName, String carType, String carNumber, String carColour) {
		super();
		this.ownerEmail = ownerEmail;
		this.carName = carName;
		this.carType = carType;
		this.carNumber = carNumber;
		this.carColour = carColour;
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

	String carColour;

}
