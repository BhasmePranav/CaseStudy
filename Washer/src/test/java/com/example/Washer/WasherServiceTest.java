package com.example.Washer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.washer.entity.*;
import com.example.washer.exceptions.InvalidWasherDetailsException;
import com.example.washer.repository.WasherRepository;
import com.example.washer.serviceimplementation.WasherServiceImpl;

@SpringBootTest
class WasherServiceTest {

	@Mock	
	WasherRepository washerRepository;
	
	@InjectMocks
	WasherServiceImpl washerServiceImpl;
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.initMocks(this.washerRepository);
	}
	
	@Test
	void registerWasherTest() throws InvalidWasherDetailsException
	{
		Washer washer = new Washer();
		washer.setEmail("pranav8@gmail.com");
		washer.setFname("PranavBhasme");
		washer.setPhoneNo("9067683203");
		
		washerServiceImpl.registerWasher(washer);
		when(washerRepository.findByEmail("pranav8@gmail.com")).thenReturn(Optional.empty());
        when(washerRepository.save(any(Washer.class))).thenReturn(washer);

        Washer registeredWasher = washerServiceImpl.registerWasher(washer);

        assertNotNull(registeredWasher);
        assertEquals("pranav8@gmail.com", registeredWasher.getEmail());
	}
	
	@Test
	void updateWasherTest() throws InvalidWasherDetailsException
	{
		String email = "test@example.com";
        Washer existingWasher = new Washer();
        existingWasher.setEmail(email);

        Washer updatedWasher = new Washer();
        updatedWasher.setFname("Updated Name");
        updatedWasher.setPhoneNo("9876543210");

        when(washerRepository.findByEmail(email)).thenReturn(Optional.of(existingWasher));
        when(washerRepository.save(any(Washer.class))).thenReturn(updatedWasher);

        Washer result = washerServiceImpl.updateWasher(email, updatedWasher);

        assertNotNull(result);
        assertEquals("Updated Name", result.getFname());
	}
	
	@Test
	void deleteWasherTest() throws InvalidWasherDetailsException
	{
		 String email = "test@example.com";
	     Washer existingWasher = new Washer();
	     existingWasher.setEmail(email);

	     when(washerRepository.findByEmail(email)).thenReturn(Optional.of(existingWasher));

	     String result = washerServiceImpl.deleteWasher(email);

	      assertNotNull(result);
	      assertEquals("Washer with test@example.com deleted Succesfully", result);
	 }
	
	@Test
	void getAllWashers() throws InvalidWasherDetailsException
	{
		List<Washer> washers = new ArrayList<>();
        washers.add(new Washer());
        washers.add(new Washer());

        when(washerRepository.count()).thenReturn((long) washers.size());
        when(washerRepository.findAll()).thenReturn(washers);

        List<Washer> result = washerServiceImpl.getAllWashers();

        assertNotNull(result);
        assertEquals(washers.size(), result.size());

	}
	
}

	
