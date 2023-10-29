package com.example.customer.service;

import java.util.List;

import com.example.customer.entity.CarDetails;
import com.example.customer.exception.InvalidCarDetailsException;
import com.example.customer.exception.InvalidUserDetailsException;

public interface CarDetailsService {
	
	public CarDetails addCarDetails(CarDetails carDetails) throws InvalidCarDetailsException;
	
	public CarDetails updateCarDetails(String carNumber , CarDetails carDetails) throws InvalidCarDetailsException, InvalidUserDetailsException;
	
	public CarDetails getByCarNumber(String carNumber) throws InvalidCarDetailsException;
	
	public List<CarDetails> getAllCars();
	
	public List<CarDetails> getCarsByEmail(String ownerEmail);
}
