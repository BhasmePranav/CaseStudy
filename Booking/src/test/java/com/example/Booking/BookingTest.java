package com.example.Booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.booking.entity.Booking;
import com.example.booking.entity.Car;
import com.example.booking.entity.Customer;
import com.example.booking.exception.InvalidCarCustomerDetails;
import com.example.booking.exception.ServiceNotAvailableException;
import com.example.booking.repository.BookingRepository;
import com.example.booking.serviceimplementation.BookingServiceImpl;

@SpringBootTest
public class BookingTest {

	@Mock
	BookingRepository bookingRepository;
	
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.initMocks(this.bookingRepository);
	}
	
//	@Test
//	void washNowTest() throws ServiceNotAvailableException, InvalidCarCustomerDetails
//	{
//		LocalTime currentTime = LocalTime.of(10, 0);
//        LocalTime serviceStart = LocalTime.of(4, 0);
//        LocalTime serviceEnd = LocalTime.of(20, 0);
//      
//        BookingServiceImpl service = (BookingServiceImpl) bookingServiceImpl;
//        //service.se(currentTime);
//
//        Booking booking = new Booking();
//        booking.setBookingDate(LocalDate.now());
//        booking.setBookingId("MH03AR0921".concat(serviceStart.toString()));
//        booking.setStartTime(serviceStart);
//        booking.setEndTime(serviceEnd);
//        booking.setStatus(null);
//        
//        booking.setCar(new Car("pranav@gmail.com", "Swift" , "HatchBack" , "MH03AR0921" , "Silver"));
//        booking.setCustomer(new Customer("Pranav" , "Bhasme" , "pranav@gmail.com" , "9067683203"));
//
//        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
//
//        Booking result = bookingServiceImpl.washNow(booking);
//
//        //assertNotNull(result);
//        assertEquals(LocalDate.now(ZoneId.of("Asia/Kolkata")), result.getBookingDate());
//        assertEquals(currentTime, result.getStartTime());
	//}
}

