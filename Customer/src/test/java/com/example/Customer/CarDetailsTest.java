package com.example.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.customer.entity.CarDetails;
import com.example.customer.exception.InvalidCarDetailsException;
import com.example.customer.exception.InvalidUserDetailsException;
import com.example.customer.repository.CarDetailsRepository;
import com.example.customer.serviceimplementation.CarDetailsServiceImpl;

@SpringBootTest
class CarDetailsTest {
	
	@Mock
	private CarDetailsRepository carDetailsRepository; 
	
	@InjectMocks
	private CarDetailsServiceImpl carDetailsServiceImpl;
	
	@BeforeEach
	void setUp()
	{
		this.carDetailsServiceImpl  = new CarDetailsServiceImpl(this.carDetailsRepository);
	}
	
	@Test
	void addCarDetails() throws InvalidCarDetailsException
	{
		CarDetails carDetails = new CarDetails();
		carDetails.setOwnerEmail("alber@gmail.com");
		carDetails.setCarName("Benz");
		carDetails.setCarType("SUV");
		carDetails.setCarNumber("MH09AF3456");
		carDetails.setCarColour("Black");

		carDetailsServiceImpl.addCarDetails(carDetails);
		CarDetails ccd = carDetailsRepository.save(carDetails);
        CarDetails cd = carDetailsRepository.findByCarNumber("MH09AF3456").orElse(ccd);
        
        assertEquals(cd,ccd);
	}
	
	@Test
	void updateCarDetailsTest() throws InvalidCarDetailsException, InvalidUserDetailsException
	{
		String carNumber = "MH09AF3456";
        CarDetails carDetailsToUpdate = new CarDetails();
        carDetailsToUpdate.setCarName("UpdatedBenz");
        carDetailsToUpdate.setCarType("UpdatedSUV");
        carDetailsToUpdate.setOwnerEmail("updated@gmail.com");
        carDetailsToUpdate.setCarNumber(carNumber);
        carDetailsToUpdate.setCarColour("UpdatedBlack");

        // Mock the behavior of carDetailsRepository
        when(carDetailsRepository.findByCarNumber(carNumber)).thenReturn(java.util.Optional.of(carDetailsToUpdate));
        when(carDetailsRepository.save(carDetailsToUpdate)).thenReturn(carDetailsToUpdate);

        // Act
        CarDetails updatedCarDetails = carDetailsServiceImpl.updateCarDetails(carNumber, carDetailsToUpdate);

        // Assert
        assertNotNull(updatedCarDetails);
        assertEquals(carDetailsToUpdate.getCarName(), updatedCarDetails.getCarName());
        assertEquals(carDetailsToUpdate.getCarType(), updatedCarDetails.getCarType());
        assertEquals(carDetailsToUpdate.getOwnerEmail(), updatedCarDetails.getOwnerEmail());
        assertEquals(carNumber, updatedCarDetails.getCarNumber());
        assertEquals(carDetailsToUpdate.getCarColour(), updatedCarDetails.getCarColour());
	}
	
	@Test
	void getBYCarNumberTest() throws InvalidCarDetailsException
	{
		CarDetails carDetails = new CarDetails("anna@gmail.com", "BMW" , "Sedane" , "MH23SD564" , "Red");
		String carNumber = "NonExistentCarNumber";
        when(carDetailsRepository.findByCarNumber(carNumber)).thenReturn(Optional.of(carDetails));
        CarDetails result = carDetailsServiceImpl.getByCarNumber(carNumber);

        // Verify that carDetailsRepository.findByCarNumber() was called with the correct argument
        verify(carDetailsRepository, times(1)).findByCarNumber(eq(carNumber));

        // Assert that the result matches the expected CarDetails object
        assertEquals(carDetails, result);
	}
	
	@Test
	void  getAllCarsTest()
	{
		List<CarDetails> carDetailsList = new ArrayList<>();
        carDetailsList.add(new CarDetails("anna@gmail.com", "BMW" , "Sedane" , "MH23SD564" , "Red"));
        carDetailsList.add(new CarDetails("nana@gmail.com", "Audi" , "hatchBack" , "MH23SD566" , "Blue"));

        when(carDetailsRepository.findAll()).thenReturn(carDetailsList);
        List<CarDetails> result = carDetailsServiceImpl.getAllCars();

        verify(carDetailsRepository, times(1)).findAll();
        assertEquals(carDetailsList, result);

	}
	
}
