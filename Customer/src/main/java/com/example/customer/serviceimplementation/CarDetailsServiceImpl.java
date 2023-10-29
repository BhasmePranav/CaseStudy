package com.example.customer.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entity.CarDetails;
import com.example.customer.exception.InvalidCarDetailsException;
import com.example.customer.exception.InvalidUserDetailsException;
import com.example.customer.repository.CarDetailsRepository;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CarDetailsService;


@Service
public class CarDetailsServiceImpl implements CarDetailsService {
	
	@Autowired
	private CarDetailsRepository carDetailsRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	
	
	public CarDetailsServiceImpl(CarDetailsRepository carDetailsRepository) {
		super();
		this.carDetailsRepository = carDetailsRepository;
	}

	@Override
	public CarDetails addCarDetails(CarDetails carDetails) throws InvalidCarDetailsException {
		
			if(carDetailsRepository.findByCarNumber(carDetails.getCarNumber()).isPresent())
			{
				throw new InvalidCarDetailsException("Car with "+carDetails.getCarNumber()+" is already register , book wash service");
			}
			else
			{
				CarDetails cd = new CarDetails();
				cd.setCarColour(carDetails.getCarColour());
				cd.setCarName(carDetails.getCarName());
				cd.setCarNumber(carDetails.getCarNumber());
				cd.setOwnerEmail(carDetails.getOwnerEmail());
				cd.setCarType(carDetails.getCarType());
				return carDetailsRepository.save(cd);
			}	
	}

	@Override
	public CarDetails updateCarDetails(String carNumber, CarDetails carDetails) throws InvalidCarDetailsException, InvalidUserDetailsException {

		CarDetails carPresent = carDetailsRepository.findByCarNumber(carNumber).orElseThrow(
				() -> new InvalidCarDetailsException("Car with "+carNumber+" is not register , please register your car"));
		
		carPresent.setCarName(carDetails.getCarName());
		carPresent.setCarColour(carDetails.getCarColour());
		carPresent.setOwnerEmail(carDetails.getOwnerEmail());
		carPresent.setCarNumber(carNumber);
		carPresent.setCarType(carDetails.getCarType());
		
		return carDetailsRepository.save(carPresent);
	}

	@Override
	public CarDetails getByCarNumber(String carNumber) throws InvalidCarDetailsException {
		
		return carDetailsRepository.findByCarNumber(carNumber).orElseThrow(() -> new InvalidCarDetailsException("Car not registered"));
	}

	@Override
	public List<CarDetails> getAllCars() {
		return carDetailsRepository.findAll();
	}

	@Override
	public List<CarDetails> getCarsByEmail(String ownerEmail) 
	{
		// TODO Auto-generated method stub
		List<CarDetails> carsWithEmail = carDetailsRepository.findByOwnerEmail(ownerEmail);
		return carsWithEmail;
	}
	
	
		

}
