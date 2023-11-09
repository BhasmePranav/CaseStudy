import { useEffect, useState } from "react";
import BookingService from "../Services/BookingService";
import WasherNavBar from "./WasherNavBar";
import "./AllBookingsForWasher.css";

function AllBookingsForWasher() {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    const fetchAllBookings = async () => {
      try {
        const response = await BookingService.getAllBookings();
        setBookings(response.data);
      } catch (error) {
        alert("Error fetching all customers data:");
        console.error("Error fetching all customers data:", error.message);
      }
    };
    fetchAllBookings();
  }, []);

  const handleAcceptBookingButton = async (bookingId) => {
    console.log(bookingId);
    try {
      await BookingService.acceptBooking(bookingId);
      window.location.reload();
    } catch (error) {
      alert("accept Handle error");
    }
  };

  const sortedBookings = bookings.sort((a, b) => {
    if (a.status === "Pending" && b.status !== "Pending") return -1;
    if (b.status === "Pending" && a.status !== "Pending") return 1;
    return 0;
  });
  return (
    <div>
      <WasherNavBar />
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
        {sortedBookings.map((booking) => (
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
            Address = {booking.address}
            <br /> 
            <a className="AddLink" href={booking.addressLink} target="_blank" rel="noopener noreferrer">Navigations</a>
            <br />
            <button
              className="AcceptBookButton"
              onClick={() => handleAcceptBookingButton(booking.bookingId)}
              disabled={booking.status === "Accepted" || booking.status === "Cancelled"}
            >
              Accept Booking
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default AllBookingsForWasher;
