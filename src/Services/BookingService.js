import axios from "axios";
const BOOKINGS_WASHNOW_API = (email, carNumber) => `http://localhost:8052/Bookings/washNow/${email}/${carNumber}`;
const BOOKINGS_WASHLATER_API = (email, carNumber) => `http://localhost:8052/Bookings/washLater/${email}/${carNumber}`;
const BOOKINGS_UPDATESTATUS_API = (bookingId) => `http://localhost:7777/Bookings/updateStatus/${bookingId}`;
const BOOKINGS_CANCEL_MY_BOOKING_API = (bookingId) => `http://localhost:8052/Bookings/cancelBooking/${bookingId}`;
const BOOKINGS_GET_ALL_BOOKINGS_API = `http://localhost:7777/Bookings/getAllBookings`;
const BOOKINGS_FIND_BOOKING_BY_ID_API = (bookingId) => `http://localhost:7777/Bookings/byId/${bookingId}`;
const BOOKINGS_FIND_BOOKING_BY_EMAIL_API = (email) => `http://localhost:8052/Bookings/bookingsByEmail/${email}`;
const BOOKINGS_ACCEPT_BOOKING_API = (bookingId) => `http://localhost:8052/Bookings/acceptBooking/${bookingId}`;
const BOOKING_CALBILL_API = (washingPackage) => `http://localhost:8052/Bookings/calBill/${washingPackage}`;

class BookingService {
    washNow(booking , email, carNumber) {
        const url = BOOKINGS_WASHNOW_API(email, carNumber);
        return axios.post(url, booking);
    }

    washLater(booking, email, carNumber) {
        const url = BOOKINGS_WASHLATER_API(email, carNumber);
        return axios.post(url, booking);
    }

    updateStatus(bookingId, booking) {
        const url = BOOKINGS_UPDATESTATUS_API(bookingId);
        return axios.put(url, booking);
    }

    cancelMyBooking(bookingId) {
        const url = BOOKINGS_CANCEL_MY_BOOKING_API(bookingId);
        return axios.put(url);
    }

    getAllBookings() {
        return axios.get(BOOKINGS_GET_ALL_BOOKINGS_API);
    }

    findByBookingId(bookingId) {
        const url = BOOKINGS_FIND_BOOKING_BY_ID_API(bookingId);
        return axios.get(url);
    }

    bookingsByEmail(email) {
        const url = BOOKINGS_FIND_BOOKING_BY_EMAIL_API(email);
        return axios.get(url);
    }

    acceptBooking(bookingId)
    {
        const url = BOOKINGS_ACCEPT_BOOKING_API(bookingId);
        return axios.put(url);
    }

    calBill(washingPackage)
    {
        const url = BOOKING_CALBILL_API(washingPackage);
        return axios.get(url);

    }
}

export default new BookingService();
