import React, { useEffect, useState } from "react";
import "./MyCars.css";
import CarService from "../Services/CarService";
import { useNavigate } from "react-router-dom";
import CustomerNavBar from "./CustomerNavBar";

function MyCars() {
  const [ownerEmail, setOwnerEmail] = useState("");
  const [carName, setCarName] = useState("");
  const [carType, setCarType] = useState("");
  const [carNumber, setCarNumber] = useState("");
  const [carColour, setCarColour] = useState("");
  const [cars, setCars] = useState([]);
  const navigate = useNavigate();

  const customer = JSON.parse(localStorage.getItem("CustomerDetails"));

  const addCarButtonHandle = async (e) => {
    e.preventDefault();

    try {
      await CarService.addCarDetails({
        ownerEmail: customer.email,
        carName: carName,
        carType: carType,
        carNumber: carNumber,
        carColour: carColour,
      });
      window.location.reload();
      alert("Car Added Successfully");
    } catch (error) {
      alert("Error in Adding Car: " + error.message);
    }
  };

  useEffect(() => {
    const fetchCarsByMail = async () => {
      try {
        const response = await CarService.getCarsByEmail(customer.email);
        setCars(response.data);
      } catch (error) {
        alert("Error Fetching all Cars data: " + error.message);
        console.error("Error fetching all cars data:", error.message);
      }
    };
    fetchCarsByMail();
  }, []);

  const HandleToBookWash = async (carNumber) => {
    try {
      const carDetailsResponse = await CarService.getByCarNumber(carNumber);
  
      if (carDetailsResponse && carDetailsResponse.data) {
        const carDetails = carDetailsResponse.data;
        localStorage.setItem("SelectedCar", JSON.stringify(carDetails));
        navigate("/BookWash");
      } else {
        alert("Error fetching car detailsssssssssssss");
      }
    } catch (error) {
      alert("Error fetching car details: " + error.message);
    }
  };

  return (
    <div>
      <CustomerNavBar />
      <div className="AddCarFormDiv">
        <form className="AddCarForm" onSubmit={addCarButtonHandle}>
          <input
            className="OwnerEmail"
            type="text"
            placeholder="Email"
            value={ownerEmail}
            onChange={(e) => setOwnerEmail(customer.email)}
          />
          <br />

          <input
            className="CarName"
            type="text"
            placeholder="Car Name"
            value={carName}
            onChange={(e) => setCarName(e.target.value)}
          />
          <br />

          <input
            className="CarType"
            type="text"
            placeholder="Car Type"
            value={carType}
            onChange={(e) => setCarType(e.target.value)}
          />
          <br />

          <input
            className="CarNumber"
            type="text"
            placeholder="Car Number"
            value={carNumber}
            onChange={(e) => setCarNumber(e.target.value)}
          />
          <br />

          <input
            className="CarColour"
            type="text"
            placeholder="Car Colour"
            value={carColour}
            onChange={(e) => setCarColour(e.target.value)}
          />
          <br />

          <button className="AddCarButton btn btn-primary "type="submit">
            Add Car
          </button>
        </form>
      </div>
      <div className="CarTypes">

      </div>

      <div className="DisplayCarByEmailDiv">
        {cars.map((car) => (
          <div className="CardForCar"
            key={car.carNumber}
            style={{padding: '10px', margin: '10px', width: 'auto' }}
          >
            <h5 className = "ICNumber">Car Number : <strong>{car.carNumber}</strong></h5>
            <h6  className="ICName">Car name : <strong>{car.carName}</strong> Car Type : <strong>{car.carType}</strong></h6>
            <h6  className="ICName">Car name : <strong>{car.carName}</strong></h6>
            <h6 className="ICType">Car Type : <strong>{car.carType}</strong></h6>
            <h6 className="ICColor">Car Colour : <strong>{car.carColour}</strong></h6>
            
            
            <button className="WashButton" onClick={() => HandleToBookWash(car.carNumber)}>Wash Now</button>
            <button className="WashButton" onClick={() => HandleToBookWash(car.carNumber)}>Wash Later</button>
            
            
          </div>
        ))}
      </div>
    </div>
  );
}

export default MyCars;
