package com.example.Washer.service;

import java.util.List;

import com.example.Washer.entity.Washer;
import com.example.Washer.exceptions.InvalidWasherDetailsException;

public interface WasherService {
	
	public Washer registerWasher(Washer washer) throws InvalidWasherDetailsException;
	
	public Washer updateWasher(String email , Washer washer) throws InvalidWasherDetailsException;

	public String DeleteWasher(String email) throws InvalidWasherDetailsException;
	
	public List<Washer> getAllWashers();
	

}
