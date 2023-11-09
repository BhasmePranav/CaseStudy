import React, { useState , useEffect } from "react";
import CustomerService from "../Services/CustomerService";
import './AllCustomers.css'

function AllCustomers() {

    const [customers , setCustomers] = useState([]);

    useEffect(() => {
      
        const fetchAllCustomers = async() => {
            try{
                const response = await CustomerService.displayAllCustomers();
                setCustomers(response.data);
            }
            catch(error)
            {
                alert("Error fetching all customers data:");
                console.error("Error fetching all customers data:", error.message);
            }
        };
        fetchAllCustomers();
    },[]);
    
    
    return ( 
        <div className="AllCustomers">
            <h1>All Customers List</h1>
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
                    {customers.map((customer) => (
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

export default AllCustomers;