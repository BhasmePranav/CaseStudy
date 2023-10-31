package com.example.booking.service;

import java.util.List;

import com.example.booking.entity.Booking;
import com.example.booking.exception.InvalidBookingIdException;
import com.example.booking.exception.InvalidCarCustomerDetails;
import com.example.booking.exception.ServiceNotAvailableException;

public interface BookingService {
	
	public Booking washNow(Booking booking) throws ServiceNotAvailableException, InvalidCarCustomerDetails;
	
	public Booking washLater(Booking booking) throws ServiceNotAvailableException, InvalidCarCustomerDetails;
	
	public String updateStatus(String bookingId , Booking booking) throws InvalidBookingIdException;
	
	public String cancelMyBooking(String bookingId) throws InvalidBookingIdException, InvalidCarCustomerDetails;
	
	public List<Booking> getAllBookings();
	
	public Booking findByBookingId(String bookinId) throws InvalidBookingIdException;
	
	public List<Booking> bookingsByEmail(String email) throws InvalidBookingIdException;
	
	public String acceptBooking(String BookingId) throws InvalidBookingIdException;
	
	public Integer calculateBill(String washingPackage);
	
	
	

}
	