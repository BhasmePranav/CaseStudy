package com.example.booking.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String>{
	
	
	@Query("{BookingId : ?0}")
	public Optional<Booking> findByBookingId(String bookingId);
	
	
	@Query("{carNumber : ?0}")
	public Optional<Booking> findBybookingByCarNumber(String carNumber);
	
	
	@Query("{BookingId : ?0}")
	public List<Booking> findBybookingsByEmail(String email);
	
	

}
