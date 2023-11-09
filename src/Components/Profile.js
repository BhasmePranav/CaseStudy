import React, { useEffect, useState } from "react";
import "./Profile.css";
import Ana from "../Images/Ana.jpg";
import CustomerService from "../Services/CustomerService";
import { useNavigate } from "react-router-dom";
import { Modal } from "react-bootstrap";

function Profile() {
  const navigate = useNavigate();
  const [customer, setCustomer] = useState("");
  const [open, setOpen] = useState(false);
  const[password , setPassword] = useState('');
  const[fname , setFname] = useState('');
  const[email , setEmail] = useState('');
  const[phoneNo , setPhoneNo] = useState('');

  const customerr = JSON.parse(localStorage.getItem("CustomerDetails"));
  const loggedInCustomerEmail = customerr.email;

  useEffect(() => {
    const getCustomerDetails = async () => {
      try {
        const response = await CustomerService.getByEmail(
          loggedInCustomerEmail
        );
        setCustomer(response.data);
      } catch (error) {
        console.log(error);
      }
    };
    getCustomerDetails();
  });

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    setOpen(true);
    setFname(customer.fname);
  setEmail(customer.email);
  setPhoneNo(customer.phoneNo);
  setPassword(customer.password);
  };

  const updateDataButtonHandle = (e) => {
      e.preventDefault();

      try
      {
          CustomerService.updateCustomer({
          fname:fname,
          email:email,
          phoneNo:phoneNo,
          password:password,
      });
      alert("UpdateSuccessfullll");
    }
      catch(error)
      {
        alert("Error in Update");
      }
  };

  const handleDeleteAccountButton =() =>
  {
    try
    {
      CustomerService.deleteCustomer(loggedInCustomerEmail);
      navigate("/");
      
    }
    catch(error)
    {
      alert("Error in Deleting");
    }
  }

  const handleLogOutButton=()=>
  {
      // localStorage.removeItem("CustomerDetails");
      // localStorage.removeItem("WasherDetails");
      // localStorage.removeItem("washerDetails");
      navigate("/");
  }

  return (
    <div className="UserProfile">
      <h3 className="HelloLine">Hello , {customer.fname}</h3>
      <div className="ProfilePic">
        <img src={Ana} alt="" className="ProfilePicImg"></img>
        <h5 className="ProfileData">Name : {customer.fname}</h5>
        <h5 className="ProfileData">Email : {loggedInCustomerEmail}</h5>
        <h5 className="ProfileData">Phone No.: {customer.phoneNo}</h5>
        <button className="DeleteAccountButton" >DeleteAccount</button>
        <br/>
        {/* <button className="LogOutButton" onClick={handleLogOutButton}>Log out</button> */}
      </div>
      <div className="DataForUpdate">
        <h3 className="DetailsHeading">Personal Details</h3>

        <button className="UpDButton" onClick={handleOpen}>
          Update
        </button>
        <h4 className="UpdateProfileData">Name : {customer.fname}</h4>
        <h4 className="UpdateProfileData">Email : {loggedInCustomerEmail}</h4>
        <h4 className="UpdateProfileData">Phone No.: {customer.phoneNo}</h4>
        <h4 className="UpdateProfileData">Password: {customer.password}</h4>
      </div>
      

      <Modal
        show={open}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>Update Your Details</Modal.Title>
        </Modal.Header>

        <Modal.Body>
          <h1>pranav</h1>
          <form className="UpdatePopUpForm">
          <input
            className="UpdateInput"
            type="Name"
            placeholder="Name"
            value={fname}
            onChange = {(e) => setFname(e.target.value)} />{" "}

          <input
            className="UpdateInput"
            type="email"
            placeholder="Email"
            value={email}
            disabled
            />{" "}

          <input
            className="UpdateInput"
            type="PhoneNumber"
            placeholder="Phone Number"
            value={phoneNo}
            onChange = {(e) => setPhoneNo(e.target.value)} />{" "}
            
            <input
            className="UpdateInput"
            type="Password"
            placeholder="Password"
            value={password}
            onChange = {(e) => setPassword(e.target.value)} />{" "}
          <br />
            <button className="UpdateDataButton" onClick={updateDataButtonHandle}>Update Profile</button>
          </form>
        </Modal.Body>

        <Modal.Footer>
          <button onClick={handleClose}>Close</button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}

export default Profile;
