import React, { useState , useEffect } from "react";
import AdminService from "../Services/AdminService";
import './AllCustomers.css'

function AllAdminList() {

    const [admins , setAdmin] = useState([]);

    useEffect(() => {
      
        const fetchAllAdmins = async() => {
            try{
                const response = await AdminService.getAllAdmins();
                setAdmin(response.data);
            }
            catch(error)
            {
                alert("Error fetching all Admins data:");
                console.error("Error fetching all Admins data:", error.message);
            }
        };
        fetchAllAdmins();
    },[]);

    const handleDeleteAdmin = (email) =>
    {
        
        try
        {
            AdminService.deleteAdmin(email);
            window.location.reload();
            alert("Admin with email "+email+"deleted Successfully");
        }
        catch(error)
        {
            alert("Admin deletion error");
        }
    }
    
    
    return ( 
        <div className="AllCustomers">
            <h1>All Admins List</h1>
            <table className="AllCusotmersTable" >
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>EMail</th>
                        <th>PhoneNumber</th>
                        <th>Password</th>
                        <th>Button</th>

                    </tr>
                </thead>
                <tbody>
                    {admins.map((admin) => (
                    <tr key = {admin.email}>
                        <th>{admin.fname}</th>
                        <th>{admin.email}</th>
                        <th>{admin.phoneNo}</th>
                        <th>{admin.password}</th>
                        <th><button onClick={ () =>handleDeleteAdmin(admin.email)}>Delete</button></th>
                    </tr>
                    ))}
                    
                </tbody>

            </table>

           
        </div>
     );
}

export default AllAdminList;