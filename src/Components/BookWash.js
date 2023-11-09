import React from "react";
import { useState ,useEffect } from "react";
import "./BookWash.css";

import BookingService from  "../Services/BookingService";
import { Navigate, useNavigate } from "react-router-dom";
import CustomerHome from "./CustomerHome";
import CustomerNavBar from "./CustomerNavBar";

function BookWash() {
  const [washingPackage, setWashingPackage] = useState("");
  const [status, setStatus] = useState("");
  const [bookingDate, setBookingDate] = useState("");
  const [startTime, setStartTime] = useState("");
  const [endTime, setEndTime] = useState("");
  const [address, setAddress] = useState("");
  const [addressLink, setAddressLink] = useState("");
  const [billAmount, setBillAmount] = useState("");
  const navigate = useNavigate();
  const [customer, setCustomer] = useState({
    fname: "",
    email: "",
    phoneNo: "",
  });
  const [car, setCar] = useState({
    ownerEmail: "",
    carName: "",
    carType: "",
    carNumber: "",
    carColor: "",
  });

  

  useEffect(() => {
    const customerr = JSON.parse(localStorage.getItem("CustomerDetails"));
    const carSelected = JSON.parse(localStorage.getItem("SelectedCar"));

    if (customerr && carSelected) {
      setCustomer(customerr);
      setCar(carSelected);
    }
  }, []);

 

  const handleBookNow =  async(e) => {
    e.preventDefault();

//    alert(washingPackage);
    try {
      const response = await BookingService.calBill(washingPackage);
      const bill = (response.data);
      //alert(bill);
    const script = document.createElement("script");
    script.src = "https://checkout.razorpay.com/v1/checkout.js";
    script.async = true;
    script.onload = () => {
      const options = {
        key: "rzp_test_RVkW9MRY5Y3UDs", // Enter your razorpay key here
        // Cok2ejoZz2bEitqNTr67mwLX
        
        amount: bill * 100, // amount in paise
        currency: "INR",
        name: "Bookings",
        description: "Test Transaction",
        image: "YOUR_LOGO_URL", // Add your logo URL here
        handler: function (response) {
          //alert(response.razorpay_payment_id);
        },
        prefill: {
          name: "Pranav",
          email: "pranavbhasme@gmail.com",
          contact: 9067683203,
        },
        notes: {
          address: "Razorpay Corporate Office",
        },
        theme: {
          color: "#3399cc",
        },
      };
      const razorpay = new window.Razorpay(options);
      razorpay.open();
    };
    document.body.appendChild(script);

    } catch (error) {
      console.error('Error calculating bill:', error);
    }
    
    
    
    
    try {
      const bookingData = {
        bookingDate: bookingDate,
        startTime: startTime,
        endTime: endTime,
        washingPackage: washingPackage,
        status: status,
        address : address,
        addressLink : addressLink,
        billAmount : billAmount
      };
      console.log(bookingData);
       await BookingService.washNow(bookingData , customer.email , car.carNumber);
      alert("Successful Booking");
      alert(washingPackage , billAmount);
      navigate("/MyBookingsCustomer");
    } catch (error) {
      console.error("Error booking now:", error);
      alert("Error booking now");
    }
  };



  
  return (
    <div className="booKOuter">
      <CustomerNavBar />
      <div className="pckgDiv">
        <h4 className="pckg">Touchless Wash : ₹1199.00</h4>
        <h4 className="pckg">Hand Wash : ₹299.00</h4>
        <h4 className="pckg">Brush Free : ₹799.00</h4>
        <h4 className="pckg">Tunnel Wash : ₹999.00</h4>
        <h4 className="pckg">Interior Vaccum clean : ₹1299.00</h4>
        <h4 className="pckg">Pressure foam wash : ₹1599.00</h4>
        <h5 className="tax">All Above prices are tax exclusive.</h5>

      </div>
      <form className="BookingForm" onSubmit={handleBookNow}>
        <input
          className="Date"
          type="Date"
          placeholder="Date"
          value={bookingDate}
          onChange={(e) => setBookingDate(e.target.value)}
          required
        />
        <br />

        <input
          className="StartTime"
          type="Time"
          placeholder="startTime"
          value={startTime}
          onChange={(e) => setStartTime(e.target.value)}
          required
        />
        <br />

        <input
          className="EndTime"
          type="Time"
          placeholder="EndTime"
          value={endTime}
          onChange={(e) => setEndTime(e.target.value)}
          required
        />
        <br />

        <input
          className="Address"
          type="Address"
          placeholder="Address"
          value={address}
          onChange={(e) => setAddress(e.target.value)}
          required
        />
        <br />

        <input
          className="AddressLink"
          type="AddressLink"
          placeholder="AddressLink"
          value={addressLink}
          onChange={(e) => setAddressLink(e.target.value)}
          required
        />
        <br />

        <select
          id="WashingPackage"
          className="WashingPackage"
          placeholder="Washing Package"
          value={washingPackage}
          onChange={(e) => {setWashingPackage(e.target.value)}} >
            
          <option value="Touchless Wash">Touchless Wash</option>
          <option value="Hand Wash">Hand Wash</option>
          <option value="Brush Free">Brush Free</option>
          <option value="Tunnel Wash">Tunnel Wash</option>
          <option value="Interior Vaccum clean">Interior Vaccum clean</option>
          <option value="Pressure foam wash">Pressure foam wash</option>
        </select>
        <br />
      
        <button className="BookNowButton" type="submit">
          Book Now
        </button>
      </form>
    </div>
  );
}

export default BookWash;
