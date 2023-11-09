import React, { useState , useEffect } from "react";
import CustomerService from "../Services/CustomerService";
import WasherService from "../Services/WasherService";
import './AllCustomers.css'

function AllWasherList() {

    const [washers , setWashers] = useState([]);

    useEffect(() => {
      
        const fetchAllWashers = async() => {
            try{
                const response = await WasherService.getAllWashers();
                setWashers(response.data);
            }
            catch(error)
            {
                alert("Error fetching all washers data:");
                console.error("Error fetching all washers data:", error.message);
            }
        };
        fetchAllWashers();
    },[]);
    
    
    return ( 
        <div className="AllCustomers">
            <h1>All Washers List</h1>
            <table className="AllCusotmersTable" >
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>EMail</th>
                        <th>PhoneNumber</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    {washers.map((customer) => (
                    <tr key = {customer.email}>
                        <th>{customer.fname}</th>
                        <th>{customer.email}</th>
                        <th>{customer.phoneNo}</th>
                        <th>{customer.password}</th>
                    </tr>
                    ))}
                    
                </tbody>

            </table>

           
        </div>
     );
}

export default AllWasherList;