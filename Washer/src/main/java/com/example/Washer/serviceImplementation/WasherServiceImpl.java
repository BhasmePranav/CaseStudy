package com.example.Washer.serviceImplementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Washer.entity.Washer;
import com.example.Washer.exceptions.InvalidWasherDetailsException;
import com.example.Washer.repository.WasherRepository;
import com.example.Washer.service.WasherService;

@Service
public class WasherServiceImpl implements WasherService  {

	@Autowired
	private WasherRepository washerRepository;
	
	@Override
	public Washer registerWasher(Washer washer) throws InvalidWasherDetailsException {
		// TODO Auto-generated method stub
		if(washer.getEmail().isEmpty()) throw new InvalidWasherDetailsException("Email is mandatory.");
		Optional<Washer> washerPresent = washerRepository.findByEmail(washer.getEmail());
		if(washerPresent.isPresent())
		{
			throw new InvalidWasherDetailsException("This email is already registered.");
		}
		else
		{
			Washer w1 = new Washer();
			w1.setId(washer.getId());
			w1.setName(washer.getName());
			w1.setEmail(washer.getEmail());
			w1.setPhoneNo(washer.getPhoneNo());
					
			return washerRepository.save(w1);
		}
		
		
	}

	@Override
	public Washer updateWasher(String email, Washer washer) throws InvalidWasherDetailsException {
		// TODO Auto-generated method stub
		Optional<Washer> washerPresent = washerRepository.findByEmail(email);
		if(washerPresent.isPresent())
		{
			Washer washerUpdate = washerPresent.get();
			washerUpdate.setId(washer.getId());
			washerUpdate.setName(washer.getName());
			washerUpdate.setPhoneNo(washer.getPhoneNo());
			return washerRepository.save(washerUpdate);
		}
		else
		{
			throw new InvalidWasherDetailsException("Email not registered , please create new account.");
		}
	}

	@Override
	public String DeleteWasher(String email) throws InvalidWasherDetailsException {
		// TODO Auto-generated method stu
		Optional<Washer> washerPresent = washerRepository.findByEmail(email);
		if(!washerPresent.isPresent()) throw new InvalidWasherDetailsException(email+" is not registered");
		else
		{
			Washer w = washerPresent.get();
			washerRepository.delete(w);
			return "Washer with "+email+" sdeleted Succesfully";
		}
	}

	@Override
	public List<Washer> getAllWashers() {
		// TODO Auto-generated method stub
		if(washerRepository.count()==0)
		{
			System.out.println("NO any washer is available.");
		}
		return washerRepository.findAll();
	}

}
