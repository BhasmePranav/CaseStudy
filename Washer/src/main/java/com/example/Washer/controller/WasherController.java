package com.example.Washer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Washer.entity.Washer;
import com.example.Washer.exceptions.InvalidWasherDetailsException;
import com.example.Washer.serviceImplementation.WasherServiceImpl;

@RestController
@RequestMapping("/Washers")
public class WasherController {
	
	@Autowired
	private WasherServiceImpl washerServiceImpl;
	
	@PostMapping("/register")
	public Washer registerWasher(@RequestBody Washer washer) throws InvalidWasherDetailsException
	{
		return washerServiceImpl.registerWasher(washer);
	}
	
	@PutMapping("/update")
	public Washer updateWasher(@RequestBody Washer washer)throws InvalidWasherDetailsException
	{
		String email = washer.getEmail();
		return washerServiceImpl.updateWasher(email, washer);
	}
	
	@DeleteMapping("/delete/{email}")
	public String delteWasher(@PathVariable String email) throws InvalidWasherDetailsException
	{
		return washerServiceImpl.DeleteWasher(email);
		
	}
	
	@GetMapping("/allWashers")
	public List<Washer> getAllWashers()
	{
		return washerServiceImpl.getAllWashers();
		
	}
}
