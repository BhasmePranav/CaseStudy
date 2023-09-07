package com.example.Washer.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Washer.entity.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer, String>{
	
	@Query("{email : ?0}")
	public Optional<Washer> findByEmail(String email);

}
