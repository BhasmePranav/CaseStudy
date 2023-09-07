package com.example.Customer.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Customer.entity.CarDetails;
import com.example.Customer.exception.InvalidCarDetailsException;
import com.example.Customer.exception.InvalidUserDetailsException;
import com.example.Customer.repository.CarDetailsRepository;
import com.example.Customer.repository.CustomerRepository;
import com.example.Customer.service.CarDetailsService;


@Service
public class CarDetailsServiceImpl implements CarDetailsService {
	
	@Autowired
	private CarDetailsRepository carDetailsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	
	
	@Override
	public CarDetails addCarDetails(CarDetails carDetails) throws InvalidCarDetailsException {
		
		if(customerRepository.findByEmail(carDetails.getOwnerEmail()).isPresent())
		{
			if(carDetailsRepository.findByCarNumber(carDetails.getCarNumber()).isPresent())
			{
				throw new InvalidCarDetailsException("Car with "+carDetails.getCarNumber()+" is already register , book wash service");
			}
			else
			{
				return carDetailsRepository.save(carDetails);
			}
		}
		throw new InvalidCarDetailsException("Owner Not Registered please create Account");
		
		
	}

	@Override
	public CarDetails updateCarDetails(String carNumber, CarDetails carDetails) throws InvalidCarDetailsException, InvalidUserDetailsException {
		// TODO Auto-generated method stub
		CarDetails carPresent = carDetailsRepository.findByCarNumber(carNumber).orElseThrow(
				() -> new InvalidCarDetailsException("Car with "+carNumber+" is not register , please register your car"));
		
		if(customerRepository.findByEmail(carDetails.getOwnerEmail()).isPresent())
		{
			carPresent.setCarName(carDetails.getCarName());
			carPresent.setCarColour(carDetails.getCarColour());
			carPresent.setOwnerEmail(carDetails.getOwnerEmail());
			carPresent.setCarNumber(carNumber);
			carPresent.setCarType(carDetails.getCarType());
			
			return carDetailsRepository.save(carPresent);
		}
		else throw new InvalidUserDetailsException("Email "+carDetails.getOwnerEmail()+" is not registered  please register this email");
		}
		

}
