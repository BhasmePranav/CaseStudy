package com.example.washer.serviceimplementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.washer.entity.Washer;
import com.example.washer.exceptions.InvalidWasherDetailsException;
import com.example.washer.repository.WasherRepository;
import com.example.washer.service.WasherService;

@Service
public class WasherServiceImpl implements WasherService  {

	@Autowired
	private WasherRepository washerRepository;
	
	@Override
	public Washer registerWasher(Washer washer) throws InvalidWasherDetailsException {
		if(washer.getEmail().isEmpty()) throw new InvalidWasherDetailsException("Email is mandatory.");
		Optional<Washer> washerPresent = washerRepository.findByEmail(washer.getEmail());
		if(washerPresent.isPresent())
		{
			throw new InvalidWasherDetailsException("This email is already registered.");
		}
		else
		{
			Washer w1 = new Washer();
			w1.setFname(washer.getFname());
			w1.setEmail(washer.getEmail());
			w1.setPhoneNo(washer.getPhoneNo());
			w1.setPassword(washer.getPassword());
					
			return washerRepository.save(w1);
		}
		
		
	}

	@Override
	public Washer updateWasher(String email, Washer washer) throws InvalidWasherDetailsException {
		Optional<Washer> washerPresent = washerRepository.findByEmail(email);
		if(washerPresent.isPresent())
		{
			Washer washerUpdate = washerPresent.get();
			washerUpdate.setFname(washer.getFname());
			washerUpdate.setPhoneNo(washer.getPhoneNo());
			washerUpdate.setPassword(washer.getPassword());
			washerUpdate.setEmail(washer.getEmail());
			
			
			return washerRepository.save(washerUpdate);
		}
		else
		{
			throw new InvalidWasherDetailsException("Email not registered , please create new account.");
		}
	}

	@Override
	public String deleteWasher(String email) throws InvalidWasherDetailsException {
		Optional<Washer> washerPresent = washerRepository.findByEmail(email);
		if(!washerPresent.isPresent()) throw new InvalidWasherDetailsException(email+" is not registered");
		else
		{
			Washer w = washerPresent.get();
			washerRepository.delete(w);
			return "Washer with "+email+" deleted Succesfully";
		}
	}

	@Override
	public List<Washer> getAllWashers() throws InvalidWasherDetailsException {
		if(washerRepository.count()==0)
		{
			throw new InvalidWasherDetailsException("No any washer Registered");
		}
		return washerRepository.findAll();
	}

	@Override
	public Washer loginWasher(String email, String password) throws InvalidWasherDetailsException {
		Washer loginWasher = washerRepository.findByEmail(email).orElseThrow(() -> new InvalidWasherDetailsException("Email not registered"));
		String loginPassword = loginWasher.getPassword();
		if(password.equals(loginPassword))
		{
			return loginWasher;
		}
		else
		{
			throw new InvalidWasherDetailsException("Invalid Credientials");
		}
	}

	@Override
	public Washer getByEmail(String email) {
		Optional<Washer> washerPresent = washerRepository.findByEmail(email);
		if(washerPresent.isPresent())
		{
			return washerPresent.get();
		}
		return null;
	}

}
