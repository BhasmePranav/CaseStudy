import NavBar from "./NavBar";
import './WelcomeScreen.css'
import BlackCar from '../Images/BlackCar.jpg'
import StandWash from '../Images/StandWash.png'
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from "react-router-dom";

function WelcomeScreen() {

   const navigate = useNavigate();
   
   const ToLoginPage = () => 
   {
      navigate(`/LoginPage`);
   }

   const ToRegisterPage = () => 
   {
      navigate(`/RegistrationPage`);
   }
    return ( 
        <div className="WelcomeScreenDiv">
           <NavBar />
            <div className="AdvText">
               <h2 className="FirstLinePara">CAR'S PARLOUR</h2>
               <p className="AtDoorStep">Book Your 60-Min Premium Car Wash At Your DoorStep</p>
               <p className="Price">Starting from just <strong>₹299</strong></p>
               <button className="Button" onClick={ToLoginPage}><strong>LogIn</strong></button>
               <button className="Button" onClick={ToRegisterPage}><strong>Register</strong></button>
            </div>

            <div className="SideImage">
               <img src = {StandWash} alt="" className="StandWashImg"></img>

            </div>
           
        </div>
     );
}

export default WelcomeScreen;