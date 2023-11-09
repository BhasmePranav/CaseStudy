import React, { useState } from "react";
import AdminNavBar from "./AdminNavBar";
import "./AdminFunctions.css";
import "./RegistrationPage.css";
import AdminService from "../Services/AdminService";
import { useNavigate } from "react-router-dom";

function AdminFunctions() {
  const [fname, setFname] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate('');

const handleRegisterAdminButton = async(e) =>
{
    e.preventDefault();

    try
    {
        await AdminService.registerAdmin({
            fname:fname,
            email:email,
            phoneNo:phoneNumber,
            password:password,
          });
          alert("Admin Registration Succesfull");
          navigate("/AllAdminList");
    }
    catch (error) {
        alert("Error in Admin Registering : ");
        console.log("Error in Admin Registering : ");
    }

}

  return (
    <div> 
        <AdminNavBar />
        <form className="AddAdminForm" onSubmit={handleRegisterAdminButton}>
        <input
            className="emailInput"
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />{" "}
          <br />

          <input
            className="nameInput"
            type="name"
            placeholder="Name" 
            value={fname}
            onChange = {(e) => setFname(e.target.value)}
            required />{" "}
            
          <br />

          <input
            className="phoneNumberInput"
            type="PhoneNo"
            placeholder="Phone Number"
            value={phoneNumber}
            onChange = {(e) => setPhoneNumber(e.target.value)}
            required />{" "}
            
          <br />

          <input
            className="passwordInput"
            type="Password"
            placeholder="Password"
            value={password}
            onChange = {(e) => setPassword(e.target.value)}
            required
             />{" "}
            
          <br />

          <button className="SubmitButtom" type="Submit">
            Register
          </button>
        </form>
    </div>

  );
}

export default AdminFunctions;
