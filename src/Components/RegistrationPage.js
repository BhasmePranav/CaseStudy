import React, { useState } from "react";
import NavBar from "./NavBar";
import "./RegistrationPage.css";
import CustomerService from "../Services/CustomerService";
import Ana from '../Images/Ana.jpg'
import Axi from '../Images/Axi.jpg'
import Chris from '../Images/Chris.jpg'
import Sam from '../Images/Sam.jpg'
import WasherService from "../Services/WasherService";
import { useNavigate } from "react-router-dom";
import validator from 'validator' 

function RegistrationPage() {
  const [fname, setFname] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("customer");
  const navigate = useNavigate('');

  const handleSubmit = async(e) => {
      e.preventDefault();

    try {
      
      if(role==="Washer")
      {
        await WasherService.registerWasher({
          fname:fname,
          email:email,
          phoneNo:phoneNumber,
          password:password,
        });
        alert("Washer Registration Succesfull");
        navigate("/WasherHome");
        console.log("Washer Registration Succesfull");
      }

      else if(role==="Admin")
      {
        alert("Registration is for admin");
      }

      else
      {
        await CustomerService.registerCustomer({
          fname:fname,
          email:email,
          phoneNo:phoneNumber,
          password:password,
        });
        alert("Customer Registration Succesfull");
        navigate("/LoginPage");
        console.log("Customer Registration Succesfull");
      }
      
    } catch (error) {
        alert("Error in Registering : ");
        console.log("Error in Registering : ");
    }
  };

  return (
    <div>
      <NavBar /> 
      <div className="ReviewDiv">
        <h3 style={{color:'black' , marginLeft:'20px' , marginTop:'-20px'}}>Customer Reviews</h3>
        <div className="Review1">
          <img src={Ana} alt="" className="AnaImage"></img>
            <h5 className="Name">Sakshi</h5>
            <p className="ReviewResponse">My car looks spotless, and I'm thrilled with their Service.!</p>
        </div>
        <div className="Review2">
          <img src={Sam} alt="" className="SamImage"></img>
            <h5 className="Name">Pranav</h5>
            <p className="ReviewResponse">"Incredibly pleased with car wash! The level of cleanliness is outstanding.</p>
        </div>
        <div className="Review3">
          <img src={Chris} alt="" className="ChrisImage"></img>
            <h5 className="Name">Rehan</h5>
            <p className="ReviewResponse">Very fast and value for money service !!!</p>
        </div>
        <div className="Review4">
          <img src={Axi} alt="" className="AxiImage"></img>
            <h5 className="Name">Jasmin</h5>
            <p className="ReviewResponse">"Never Seen My car like This" , Amazing Job</p>
        </div>

      </div>
      <div className="RegiPage">
        <form className="RegiForm" onSubmit={handleSubmit}>
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

          <select
            id="role"
            className="roleInput"
            placeholder="Role"
            value={role}
            onChange={(e) => {setRole(e.target.value)
              console.log(role)}}
          >
            <option value="customer">Customer</option>
            <option value="Washer">Washer</option>
            <option value="Admin">Admin</option>
          </select>
          <br />


          <button className="SubmitButtom" type="Submit">
            Register
          </button>
          </form>
      </div>
    </div>
  );
}

export default RegistrationPage;
