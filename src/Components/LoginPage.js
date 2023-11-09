import React, { useState } from "react";
import CustomerService from "../Services/CustomerService";
import "./LoginPage.css";
import { useNavigate } from "react-router-dom";
import NavBar from "./NavBar";
import WasherService from "../Services/WasherService";
import AdminService from "../Services/AdminService";

function Loginpage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const [role, setRole] = useState("Customer");

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      if (role === "Customer") {
        const response = await CustomerService.loginCustomer(email, password);
        if (response.data) {
          alert("Customer Logged in");
          console.log(
            "Logged in successfully. CustomerDetails:",
            response.data
          );

          localStorage.setItem(
            "CustomerDetails",
            JSON.stringify(response.data)
          );
          navigate("/CustomerHome");
        } else {
          alert("Invalid credentials");
        }
      } else if (role === "Washer") {
        const response = await WasherService.loginWasher(email, password);
        if (response.data) {
          alert("Washer logged In ");
          console.log(
            "Logged in successfully. WasherDetails:",
            response.data
          );

          localStorage.setItem(
            "WasherDetails",
            JSON.stringify(response.data)
          );
          navigate("/WasherHome");
        } else {
          alert("Invalid credentials");
        }
      }
      else if (role === "Admin") {
        const response = await AdminService.loginAdmin(email, password);
        if (response.data) {
          alert("Admin logged In ");
          console.log(
            "Logged in successfully. AdminDetails:",
            response.data
          );

          localStorage.setItem(
            "AdminDetails",
            JSON.stringify(response.data)
          );
          navigate("/AdminHome");
        } else {
          alert("Invalid credentials");
        }
      }
    } catch (error) {
      // Handle other errors
      console.error("Login error:", error);
      alert("An error occurred during login");
    }
  };

  return (
    <div className="OuterLogin">
      <NavBar />

      
      <div className="LoginDiv">
        <form className="LoginForm" onSubmit={handleLogin}>
          <input
            className="LoginEmail"
            type="email" // Use type="email" for email input
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <br />

          <input
            className="LoginPassword"
            type="password" // Use type="password" for password input
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <br />

          <select
            id="role"
            className="RoleInputLogin"
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
          <button className="LoginButton" type="submit">
            Login
          </button>
        </form>
      </div>
    </div>
  );
}

export default Loginpage;
