package com.example.booking.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Document(collection = "BookingsTrial")
public class Booking {
	
	@MongoId
	private String bookingId;
	
	@JsonFormat(pattern = "yyyy-MM-dd" ,shape = Shape.STRING)
	private LocalDate bookingDate;
	
	@JsonFormat(pattern = "HH:mm" ,shape = Shape.STRING)
	private LocalTime startTime;
	
	@JsonFormat(pattern = "HH:mm" ,shape = Shape.STRING)
	private LocalTime endTime;
	
	private String washingPackage;
	
	private String status;
	
	private String address;
	
	private String addressLink;
	
	private Integer billAmount;
	
	public String getWashingPackage() {
		return washingPackage;
	}


	public void setWashingPackage(String washingPackage) {
		this.washingPackage = washingPackage;
	}

	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	private Customer customer;
	
	private Car car;
	
	
	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Booking() {
		super();
	}
	
	
	public Booking(String bookingId, LocalDate bookingDate, LocalTime startTime, LocalTime endTime , String washingPackage ,String status ,
			String address , String addressLink , Integer billAmount) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.washingPackage = washingPackage;
		this.status = status;
		this.address = address;
		this.addressLink = addressLink;
		this.billAmount = billAmount;
	}
	
	
	public Integer getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddressLink() {
		return addressLink;
	}


	public void setAddressLink(String addressLink) {
		this.addressLink = addressLink;
	}


	public String getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
}
