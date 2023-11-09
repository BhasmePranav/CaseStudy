import jsPDF from "jspdf";
import React, { useEffect, useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import BookingService from "../Services/BookingService";
import CustomerNavBar from "./CustomerNavBar";
import "./MyBookingsCustomer.css";

function MyBookingsCustomer() {
  const [bookings, setBookings] = useState([]);
  const navigate = useNavigate();

  const customer = JSON.parse(localStorage.getItem("CustomerDetails"));
  

  useEffect(() => {
    const fetchBookingsByEmail = async () => {
      try {
        const response = await BookingService.bookingsByEmail(customer.email);
        setBookings(response.data);
      } catch (error) {
        alert("Error fetching all customers data:");
        console.error("Error fetching all customers data:", error.message);
      }
    };
    fetchBookingsByEmail();
  }, []);



  const cancelBooking = async (bookingId) => {
    try {
      await BookingService.cancelMyBooking(bookingId);
      window.location.reload();
      //alert("Booking Cancelled Successfull");
    } catch (error) {
      alert("Erro in Cancelling Booking");
    }
  };


  const sortedBookings = bookings.sort((a, b) => {
    if (a.status === "Pending" && b.status !== "Pending") return -1;
    if (b.status === "Pending" && a.status !== "Pending") return 1;
    return 0;
  });


  const handleReceipt = (booking) =>
  {
    
    const pdf = new jsPDF();
    const pageWidth = pdf.internal.pageSize.width;
    const textWidth = pdf.getStringUnitWidth('CarWash...') * pdf.internal.getFontSize() / pdf.internal.scaleFactor;

    const leftCenter = (pageWidth - textWidth) / 2;

    pdf.text('CarWash...', leftCenter , 10, { font: 'Times New Roman' , fontSize : '80px' , fontWeight : 'bold' });

    pdf.text(`Booking Details`, 20 , 20 , {fontSize:'40px' , fontWeight : 'bold' , underline: true});
    pdf.text(`Booking Id : ${booking.bookingId}` , 20 , 30);
    pdf.text(`Booking-Date : ${booking.bookingDate}` , 125 , 30);
    pdf.text(`Start-Time : ${booking.startTime}` , 20 , 40);
    pdf.text(`End-Time : ${booking.endTime}` , 125 , 40);
    pdf.text(`Washing-Package : ${booking.washingPackage}` , 20 , 50);
    pdf.text(`Bill-Amount : ${booking.billAmount}` , 20 , 60 , {fontSize : '40px' , fontWeight : 'bold'});
    pdf.text(`Address : ${booking.address}` , 20 , 70);
    pdf.text(`Customer Details`, 20 , 90 , {fontSize:'40px' , fontWeight : 'bold' ,underline: true} );
    pdf.text(`Name : ${booking.customer.fname}` , 20 , 100);
    pdf.text(`Email : ${booking.customer.email}` , 20 , 110);
    pdf.text(`Phone No. : ${booking.customer.phoneNo}` , 20 , 120);
    pdf.text(`Car Details`, 125 , 90 , {fontSize:'40px' , fontWeight : 'bold' ,underline: true});
    pdf.text(`Car Name. : ${booking.car.carName}` , 125 , 100);
    pdf.text(`Car Number. : ${booking.car.carNumber}` , 125 , 110);
    

    
    if(pdf.save("CarwashReciept.pdf"))
    {
      alert("Saved Successfully");
    }
    else
    {
      alert("Saved Failed");
    }
  }


  return (
    <div className="BookingCustomerOuter">
      <CustomerNavBar />
      <div className="MainForInfoCol">
      <div className="InfoCol">
      <h4 className="TitleStat" style={{ color: 'green', border: '2px Solid green' }}>Pending  </h4>
      </div>

      <div className="InfoCol">
      <h4 className="TitleStat" style={{ color: 'blue' , border: '2px Solid blue'}}>Accepted  </h4> 
      </div>

      <div className="InfoCol">
      <h4 className="TitleStat" style={{ color: 'Red', border: '2px Solid Red' }}>Cancelled  </h4>
      </div>
      </div>
      
      
      
      <div className="BookingCardDiv">
        {bookings.map((booking) => (
          <div className={`IndvCard ${booking.status === "Cancelled" ? "cancelled" : ""} ${booking.status === "Accepted" ? "accepted" : ""}`}>
            Booking Id = {booking.bookingId}
            <br />
            Booking Date={booking.bookingDate}
            <br />
            Start Time={booking.startTime}
            <br />
            End Time={booking.endTime}
            <br />
            Washing Package = {booking.washingPackage}
            <br />
            Status = {booking.status}
            <br />
            Owner PhoneNumber = {booking.customer.phoneNo}
            <br />
            Owner Email = {booking.customer.email}
            <br />
            Car Name = {booking.car.carName}
            <br />
            car Number = {booking.car.carNumber}
            <br />
            car Type = {booking.car.carType}
            <br />
            Price = {booking.billAmount}
            <br /> 
            Address = {booking.address}
            <br /> 
            <a className="AddLink" href={booking.addressLink} target="_blank" rel="noopener noreferrer">Navigations</a>
            <br />
            <button
              className="CancelBookButton"
              onClick={() => cancelBooking(booking.bookingId)}
              disabled={booking.status === "Accepted" || booking.status === "Cancelled"}>
              Cancel Booking
            </button>
            <button className="GetReceiptButton" onClick={() => handleReceipt(booking)} >Get Receipt</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default MyBookingsCustomer;
