package com.example.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.entity.CarDetails;
import com.example.Customer.exception.InvalidCarDetailsException;
import com.example.Customer.exception.InvalidUserDetailsException;
import com.example.Customer.serviceImplementation.CarDetailsServiceImpl;

@RestController
@RequestMapping("/Cars")
public class CarDetailsController {

	@Autowired
	private CarDetailsServiceImpl carDetailsServiceImpl;
	
	@PostMapping("/addCarDetails")
	private CarDetails addCarDetails(@RequestBody CarDetails carDetails) throws InvalidCarDetailsException
	{
		return carDetailsServiceImpl.addCarDetails(carDetails);
	}
	
	@PutMapping("/updateCarDetails/{carNumber}")
	private CarDetails updateCarDetails(@PathVariable String carNumber, @RequestBody CarDetails carDetails) throws InvalidCarDetailsException, InvalidUserDetailsException {
		return carDetailsServiceImpl.updateCarDetails(carNumber, carDetails);
		
	}
	
}
