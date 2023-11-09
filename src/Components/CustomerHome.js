import React from "react";
import { Navbar , Nav } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import './CustomerHome.css';
import CustomerNavBar from './CustomerNavBar';
import Touchless from '../Images/Touchless.jpg';
import Handwash from '../Images/Handwash.jpg';
import TunnelWash from '../Images/TunnelWash.jpg';
import InteriorVaccum from '../Images/InteriorVaccum.jpg';


function CustomerHome() {

  const navigate = useNavigate("");

  const ToMyCars = () =>{
    
    navigate(`/MyCars`);
  }

  return (
   <div>
    
    <CustomerNavBar />
    <div className="HomeDesign">
                <h1 className="HeadingCust">
                    We Offer 11 Different Types Of Car Wash Services
                </h1>
                <br></br>
                <h2 className="Heading2Cust">
                    Touchless Wash , Interior Vaccum Wash , Brush Free Wash , Tunnel Wash And Many More.
                </h2>
                <h3 className="Heading3Cust">
                    24 * 7 Service , secure facilities , surveillance cameras , and trained  staff members
                    <br/>
                    <br/>
                    <h3 className="Heading4Cust">
                    Book More Wash For Your Car And Earn More Water Gallons
                    </h3>
                </h3>
                <button className="BtnBookN" onClick={ToMyCars}>Book Wash Now</button>
                

            </div>
    
    </div>
  );
}

export default CustomerHome;
