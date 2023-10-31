package com.example.washer.service;

import java.util.List;
import com.example.washer.entity.Washer;
import com.example.washer.exceptions.InvalidWasherDetailsException;

public interface WasherService {
	
	public Washer registerWasher(Washer washer) throws InvalidWasherDetailsException;
	
	public Washer updateWasher(String email , Washer washer) throws InvalidWasherDetailsException;

	public String deleteWasher(String email) throws InvalidWasherDetailsException;
	
	public List<Washer> getAllWashers() throws InvalidWasherDetailsException;
	
	public Washer loginWasher(String email , String password) throws InvalidWasherDetailsException;
	
	public Washer getByEmail(String email);

}
