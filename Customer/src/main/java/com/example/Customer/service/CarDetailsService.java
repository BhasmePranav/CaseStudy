package com.example.Customer.service;

import com.example.Customer.entity.CarDetails;
import com.example.Customer.exception.InvalidCarDetailsException;
import com.example.Customer.exception.InvalidUserDetailsException;

public interface CarDetailsService {
	
	public CarDetails addCarDetails(CarDetails carDetails) throws InvalidCarDetailsException;
	
	public CarDetails updateCarDetails(String carNumber , CarDetails carDetails) throws InvalidCarDetailsException, InvalidUserDetailsException;

}
