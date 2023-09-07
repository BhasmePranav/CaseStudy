package com.example.Customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Customer.entity.CarDetails;


@Repository
public interface CarDetailsRepository extends MongoRepository<CarDetails, String>{
	
	@Query("{'carNumber': ?0}")
	public Optional<CarDetails> findByCarNumber(String carNumber);
	
	
	@Query("{ownerEmail : ?0}")
	public List<CarDetails> findByOwnerEmail(String ownerEmail);

}
