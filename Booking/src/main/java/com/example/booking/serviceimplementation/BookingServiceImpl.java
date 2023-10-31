package com.example.booking.serviceimplementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.booking.entity.Booking;
import com.example.booking.exception.InvalidBookingIdException;
import com.example.booking.exception.InvalidCarCustomerDetails;
import com.example.booking.exception.ServiceNotAvailableException;
import com.example.booking.repository.BookingRepository;
import com.example.booking.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	String startStatus = "Pending";
	
	@Override
	public Booking washNow(Booking booking) throws ServiceNotAvailableException, InvalidCarCustomerDetails {


		String generatedId = booking.getCar().getCarNumber().concat( booking.getStartTime().toString());
		
		Integer billPrice = calculateBill(booking.getWashingPackage());
		
				Booking bookNow = new Booking();
				bookNow.setBookingId(generatedId);
				bookNow.setBookingDate(booking.getBookingDate());
				bookNow.setStartTime(booking.getStartTime());
				bookNow.setEndTime(booking.getEndTime());
				bookNow.setStatus("Pending");
				bookNow.setWashingPackage(booking.getWashingPackage());
				bookNow.setCustomer(booking.getCustomer());
				bookNow.setCar(booking.getCar());
				bookNow.setAddress(booking.getAddress());
				bookNow.setAddressLink(booking.getAddressLink());
				bookNow.setBillAmount(billPrice);
				return bookingRepository.save(bookNow);
			
	}


	@Override
	public Booking washLater(Booking booking) throws ServiceNotAvailableException, InvalidCarCustomerDetails {
		
		String generatedId = booking.getCar().getCarNumber().concat( booking.getStartTime().toString());
		Integer billPrice = calculateBill(booking.getWashingPackage());
		
		Booking bookNow = new Booking();
		bookNow.setBookingId(generatedId);
		bookNow.setBookingDate(booking.getBookingDate());
		bookNow.setStartTime(booking.getStartTime());
		bookNow.setEndTime(booking.getEndTime());
		bookNow.setWashingPackage(booking.getWashingPackage());
		bookNow.setStatus(booking.getStatus());
		bookNow.setCustomer(booking.getCustomer());
		bookNow.setCar(booking.getCar());
		bookNow.setAddress(booking.getAddress());
		bookNow.setAddressLink(booking.getAddressLink());
		bookNow.setBillAmount(billPrice);
		
		return bookingRepository.save(bookNow);
	
			
		
	}
	
	
	@Override
	public String updateStatus(String bookingId , Booking booking) throws InvalidBookingIdException {
		
		Booking bookingNow = bookingRepository.findByBookingId(bookingId).orElseThrow(
				() -> new InvalidBookingIdException("Invalid Booking ID Please confirm bookingID"));
		
		bookingNow.setStatus(booking.getStatus());
		bookingRepository.save(bookingNow);
		
		return "Status set to "+booking.getStatus()+" succesfully";
	}
	
	
	@Override
	public String cancelMyBooking(String bookingId) throws InvalidBookingIdException, InvalidCarCustomerDetails  {

		
		
		Booking bookingForCancel = bookingRepository.findByBookingId(bookingId).orElseThrow(() -> new InvalidBookingIdException("Booking not found"));
		Integer billPrice = calculateBill(bookingForCancel.getWashingPackage());
		Booking bookNow = new Booking();
		bookNow.setBookingId(bookingForCancel.getBookingId());
		bookNow.setBookingDate(bookingForCancel.getBookingDate());
		bookNow.setStartTime(bookingForCancel.getStartTime());
		bookNow.setEndTime(bookingForCancel.getEndTime());
		bookNow.setWashingPackage(bookingForCancel.getWashingPackage());
		bookNow.setCustomer(bookingForCancel.getCustomer());
		bookNow.setCar(bookingForCancel.getCar());
		bookNow.setAddress(bookingForCancel.getAddress());
		bookNow.setAddressLink(bookingForCancel.getAddressLink());
		bookNow.setBillAmount(billPrice);
		bookNow.setStatus("Cancelled");
		bookingRepository.save(bookNow);
		return "Booking "+bookingId+" Acceptedd";
	}
	
	
	@Override
	public List<Booking> getAllBookings()
	{
		return bookingRepository.findAll();
	}
	


	@Override
	public Booking findByBookingId(String bookinId) throws InvalidBookingIdException {
		return bookingRepository.findByBookingId(bookinId).orElseThrow(
				() -> new InvalidBookingIdException("No booking with this ID"));
	}

	
	
	@Override
	public List<Booking> bookingsByEmail(String email) throws InvalidBookingIdException {

		
		List<Booking> bookingList = bookingRepository.findAll();
		List<Booking> bookingByEmail = new ArrayList<>();
		for(Booking x : bookingList)
		{
			if(x.getCustomer().getEmail().equalsIgnoreCase(email))
			{
				bookingByEmail.add(x);
			}
		}
		if(bookingList.isEmpty())
		{
			throw new InvalidBookingIdException("No booking with given email");
		}
		return bookingByEmail;
		
	}


	@Override
	public String acceptBooking(String bookingId) throws InvalidBookingIdException {
		// TODO Auto-generated method stub
			Booking bookingForAccept = bookingRepository.findByBookingId(bookingId).orElseThrow(() -> new InvalidBookingIdException("Booking not found"));
			Booking bookNow = new Booking();
			bookNow.setBookingId(bookingForAccept.getBookingId());
			bookNow.setBookingDate(bookingForAccept.getBookingDate());
			bookNow.setStartTime(bookingForAccept.getStartTime());
			bookNow.setEndTime(bookingForAccept.getEndTime());
			bookNow.setWashingPackage(bookingForAccept.getWashingPackage());
			bookNow.setCustomer(bookingForAccept.getCustomer());
			bookNow.setCar(bookingForAccept.getCar());
			bookNow.setStatus("Accepted");
			
			bookingRepository.save(bookNow);
			return "Booking "+bookingId+" Acceptedd";
			
	}


	@Override
	public Integer calculateBill(String washingPackage) {
		Integer bookingPrice = 0;
		// TODO Auto-generated method stub
		if(washingPackage.equalsIgnoreCase("Touchless Wash")) {
			Integer packagePrice = 1199;
			bookingPrice = (int) Math.round( packagePrice+(packagePrice*0.18));
			return bookingPrice;
			
		}
		else if(washingPackage.equalsIgnoreCase("Hand Wash")) {
			Integer packagePrice = 299;
			bookingPrice = (int) Math.round( packagePrice+(packagePrice*0.18));
			return bookingPrice;
			
			
		}
		else if(washingPackage.equalsIgnoreCase("Brush Free")) {
			Integer packagePrice = 799;
			bookingPrice = (int) Math.round( packagePrice+(packagePrice*0.18));
			return bookingPrice;
	
		}
		else if(washingPackage.equalsIgnoreCase("Tunnel Wash")) {
			Integer packagePrice = 999;
			bookingPrice = (int) Math.round( packagePrice+(packagePrice*0.18));
			return bookingPrice;
	
		}
		else if(washingPackage.equalsIgnoreCase("Interior Vaccum clean")) {
			Integer packagePrice = 1299;
			bookingPrice = (int) Math.round( packagePrice+(packagePrice*0.18));
			return bookingPrice;
			
		}
		else if(washingPackage.equalsIgnoreCase("Pressure foam wash")) {
			Integer packagePrice = 1599;
			bookingPrice = (int) Math.round( packagePrice+(packagePrice*0.18));
			return bookingPrice;
	
		}
		else
		{
			return null;
		}
	}




	


	
}
