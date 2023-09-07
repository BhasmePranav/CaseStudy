package com.example.Customer.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Customer.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	@Query("{email:?0}")
	public Optional<Customer> findByEmail(String email);
}
