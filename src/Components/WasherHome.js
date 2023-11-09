import WasherNavBar from "./WasherNavBar";
import './WasherHome.css'
import { useNavigate } from "react-router-dom";

function WasherHome() {

    const navigate = useNavigate();
    const handleAllBookingsButton = () =>
    {
        navigate("/AllBookingsForWasher");
    }
    return ( 
        <div className="main">
            <WasherNavBar />
            <div className="HomeDesign">
                <h1 className="Heading">
                    Accept More Bookings And get Extra Bonus Coins
                </h1>
                <br></br>
                <h2 className="Heading2">
                    Redeem coins on FlipKart , Amazon!!!
                </h2>
                <button className="CheckOrdersButton" onClick={handleAllBookingsButton}>See All Bookings Here</button>

            </div>
        </div>
     );
}

export default WasherHome;