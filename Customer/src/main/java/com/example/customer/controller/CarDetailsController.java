package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.CarDetails;
import com.example.customer.exception.InvalidCarDetailsException;
import com.example.customer.exception.InvalidUserDetailsException;
import com.example.customer.serviceimplementation.CarDetailsServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Cars")
public class CarDetailsController {

	@Autowired
	private CarDetailsServiceImpl carDetailsServiceImpl;
	
	@PostMapping("/addCarDetails")
	CarDetails addCarDetails(@RequestBody CarDetails carDetails) throws InvalidCarDetailsException
	{
		return carDetailsServiceImpl.addCarDetails(carDetails);
	}
	
	@PutMapping("/updateCarDetails/{carNumber}")
	CarDetails updateCarDetails(@PathVariable String carNumber, @RequestBody CarDetails carDetails) throws InvalidCarDetailsException, InvalidUserDetailsException {
		return carDetailsServiceImpl.updateCarDetails(carNumber, carDetails);
		
	}
	
	@GetMapping("/getByCarNumber/{carNumber}")
	CarDetails getByCarNumber(@PathVariable String carNumber) throws InvalidCarDetailsException
	{
		return carDetailsServiceImpl.getByCarNumber(carNumber);
		
	}
	
	@GetMapping("/allCars")
	public List<CarDetails> getAllCars()
	{
		return carDetailsServiceImpl.getAllCars();
		
	}
	
	@GetMapping("/getAllCarsByEmail/{OwnerEmail}")
	public List<CarDetails> getCarsByEmail(@PathVariable String OwnerEmail)
	{
		return carDetailsServiceImpl.getCarsByEmail(OwnerEmail);
	}
	
}
