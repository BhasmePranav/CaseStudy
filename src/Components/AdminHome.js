import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import AdminService from "../Services/AdminService";
import "./AdminHome.css"
import AdminNavBar from "./AdminNavBar";

function AdminHome() {
    
    const navigate = useNavigate();


    const [fname, setFname] = useState("");
    const [email, setEmail] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [password, setPassword] = useState("");
    
    const handleAdminList = async(e) =>
    {
        navigate("/AllAdminList");
        
    }

    const handleUserList = () =>
    {
        navigate("/AllCustomers");

    }
    const handleWasherList = () =>
    {
        navigate("/AllWasherList");
    }
    const handleBookingList = () =>
    {
        navigate("/AllBookingsForWasher");
    }

    

    return ( 
        <div className="AdminHome1">
            <AdminNavBar />
            <button className="adminButtons" onClick={handleUserList}>
                User List
            </button>

            <button className="adminButtons" onClick={handleWasherList}>
                Washer List
            </button>

            <button className="adminButtons" onClick={handleBookingList}>
                Bookings List
            </button>

            <button className="adminButtons" onClick={handleAdminList}>
                Admin List
            </button>
        </div>
     );
}

export default AdminHome;