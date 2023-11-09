import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import WasherService from "../Services/WasherService";
import Ana from "../Images/Ana.jpg";
import { Modal } from "react-bootstrap";

function WasherProfile() {
  const navigate = useNavigate();
  const [washer, setWasher] = useState("");
  const [open, setOpen] = useState(false);
  const [password, setPassword] = useState("");
  const [fname, setFname] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");

  const washerr = JSON.parse(localStorage.getItem("WasherDetails"));

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    setOpen(true);
    setFname(washer.fname);
  setEmail(washer.email);
  setPhoneNo(washer.phoneNo);
  setPassword(washer.password);
  };

  useEffect(() => {
    const getWasherDetails = async () => {
      try {
        const response = await WasherService.getByEmail(
          washerr.email
        );
        setWasher(response.data);
      } catch (error) {
        alert("error in Profile");
      }
    };
    getWasherDetails();
  });

  const updateDataButtonHandle = async (e) => {
    e.preventDefault();
    try {
     await WasherService.updateWasher({
        fname: fname,
        email: email,
        phoneNo: phoneNo,
        password: password,
      });

      alert("UpdateSuccessfullll");
    } catch (error) {
      alert("Error in Update");
    }
  };

  const handleDeleteAccountButton = () => {
    try {
      WasherService.deleteWasher(washerr.email);
      navigate("/");
    } catch (error) {
      alert("Error in Deleting");
    }
  };

  return (
    <div className="UserProfile">
      <h3 className="HelloLine">Hello , {washer.fname}</h3>
      <div className="ProfilePic">
        <img src={Ana} alt="" className="ProfilePicImg"></img>
        <h5 className="ProfileData">Name : {washer.fname}</h5>
        <h5 className="ProfileData">Email : {washer.email}</h5>
        <h5 className="ProfileData">Phone No.: {washer.phoneNo}</h5>
        <button
          className="DeleteAccountButton"
          onClick={handleDeleteAccountButton}
        >
          DeleteAccount
        </button>
      </div>
      <div className="DataForUpdate">
        <h3 className="DetailsHeading">Personal Details</h3>

        <button className="UpDButton" onClick={handleOpen}>
          Update
        </button>
        <h4 className="UpdateProfileData">Name : {washer.fname}</h4>
        <h4 className="UpdateProfileData">Email : {washer.email}</h4>
        <h4 className="UpdateProfileData">Phone No.: {washer.phoneNo}</h4>
        <h4 className="UpdateProfileData">Password: {washer.password}</h4>
      </div>
      <div className="PaymentDiv">
        <h3 className="DetailsHeading">Payment Details</h3>
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
          <form className="UpdatePopUpForm">
            <input
              className="UpdateInput"
              type="Name"
              placeholder="Name"
              value={fname}
              onChange={(e) => setFname(e.target.value)}
            />{" "}
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
              onChange={(e) => setPhoneNo(e.target.value)}
            />{" "}
            <input
              className="UpdateInput"
              type="Password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />{" "}
            <br />
            <button
              className="UpdateDataButton"
              onClick={updateDataButtonHandle}
            >
              Update Profile
            </button>
          </form>
        </Modal.Body>

        <Modal.Footer>
          <button onClick={handleClose}>Close</button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}

export default WasherProfile;
