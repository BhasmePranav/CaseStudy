package com.example.booking.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Car;
import com.example.booking.entity.Customer;
import com.example.booking.exception.InvalidBookingIdException;
import com.example.booking.exception.InvalidCarCustomerDetails;
import com.example.booking.exception.ServiceNotAvailableException;
import com.example.booking.serviceimplementation.BookingServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Bookings")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	
	@Autowired
	private RestTemplate restTemplate;
	 
	private static final Logger log = LoggerFactory.getLogger(BookingController.class);

	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/washNow/{x_email}/{carNumber}")
	public Booking washNow(@RequestBody Booking booking , @PathVariable(name = "x_email") String email , @PathVariable String carNumber) throws ServiceNotAvailableException, InvalidCarCustomerDetails
	{
		
		Customer customer=restTemplate.getForObject("http://Customers/Customers/byEmail/"+email,Customer.class);
		Car car = restTemplate.getForObject("http://Customers/Cars/getByCarNumber/"+carNumber,Car.class );
		if(customer!=null) {
		booking.setCustomer(customer);
		booking.setCar(car);
		return bookingServiceImpl.washNow(booking);}
		else
			throw new InvalidCarCustomerDetails("car is nullllllllllllllllllllllllllllllllllll");
	}

	
	@PostMapping("/washLater/{email}/{carNumber}")
	public Booking washLater(@RequestBody Booking booking ,@PathVariable String email ,@PathVariable String carNumber) throws ServiceNotAvailableException, InvalidCarCustomerDetails
	{
		Customer customer = restTemplate.getForObject("http://localhost:8050/Customers/byEmail/"+email , Customer.class);
		Car car = restTemplate.getForObject("http://localhost:8050/Cars/getByCarNumber/"+carNumber, Car.class);
		booking.setCustomer(customer);
		booking.setCar(car);
		return bookingServiceImpl.washLater(booking);
		
	}
	
	
	@PutMapping("/updateStatus/{BookingId}")
	public String updateStatus(@PathVariable String bookingId ,@RequestBody Booking booking) throws InvalidBookingIdException
	{
		return bookingServiceImpl.updateStatus(bookingId, booking);
	}
	
	@PutMapping("/cancelBooking/{bookingId}")
	public String cancelMyBooking(@PathVariable String bookingId) throws InvalidBookingIdException, InvalidCarCustomerDetails 
	{
		return bookingServiceImpl.cancelMyBooking(bookingId);
		
	}
	
	
	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings()
	{
		return bookingServiceImpl.getAllBookings();
	}
	
	
	@GetMapping("/byId/{bookingId}")
	public Booking findByBookingId(@PathVariable String bookingId) throws InvalidBookingIdException {
		return bookingServiceImpl.findByBookingId(bookingId);
	}
	
	
	
	@GetMapping("/bookingsByEmail/{email}")
	public List<Booking> bookingsByEmail(@PathVariable String email) throws InvalidBookingIdException {
		return bookingServiceImpl.bookingsByEmail(email);
		
	}
	
	@PutMapping("/acceptBooking/{bookingId}")
	public String acceptBooking(@PathVariable String bookingId) throws InvalidBookingIdException
	{
		return bookingServiceImpl.acceptBooking(bookingId);
	}
	
	@GetMapping("/calBill/{washingPackage}")
	public Integer calculateBill(@PathVariable String washingPackage) 
	{
		return bookingServiceImpl.calculateBill(washingPackage);
	}
}
