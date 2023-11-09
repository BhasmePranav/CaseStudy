import React from 'react';
import './App.css';
import RegistrationPage from './Components/RegistrationPage';
import {BrowserRouter as Router , Routes ,Route } from 'react-router-dom'
import AllCustomers from './Components/AllCustomers';
import LoginPage from './Components/LoginPage';
import WelcomeScreen from './Components/WelcomeScreen';
import CustomerHome from './Components/CustomerHome';
import BookWash from './Components/BookWash';
import MyCars from './Components/MyCars';
import Profile from './Components/Profile';
import MyBookingsCustomer from './Components/MyBookingsCustomer';
import WasherHome from './Components/WasherHome';
import AllBookingsForWasher from './Components/AllBookingsForWasher';
import WasherProfile from './Components/WasherProfile';
import AdminHome from './Components/AdminHome';
import AllWasherList from './Components/AllWashersList';
import AllAdminList from './Components/AllAdminList';
import AdminFunctions from './Components/AdminFunctions';

function App() {
  return (
   <div className="AppDiv"> 

    <Router> 
      <Routes>
        <Route path="/" element={<WelcomeScreen/>}></Route>
        <Route path= "/RegistrationPage" element={<RegistrationPage />}></Route>
        <Route path = "/AllCustomers" element={<AllCustomers />}></Route> 
        <Route path = "/LoginPage" element={<LoginPage />}></Route>
        <Route path= "/CustomerHome" element={<CustomerHome/>}></Route>
        <Route path= "/BookWash" element={<BookWash/>}></Route>
        <Route path= "/MyCars" element={<MyCars />}></Route>
        <Route path= "/Profile" element={<Profile />}></Route>
        <Route path= "/MyBookingsCustomer" element={<MyBookingsCustomer />}></Route>
        <Route path= "/WasherHome" element={<WasherHome />}></Route>
        <Route path= "/AllBookingsForWasher" element={<AllBookingsForWasher />}></Route>
        <Route path= "/WasherProfile" element={<WasherProfile />}></Route>
        <Route path= "/AdminHome" element={<AdminHome />}></Route>
        <Route path= "/AllWasherList" element={<AllWasherList />}></Route>
        <Route path= "/AllAdminList" element={<AllAdminList />}></Route>
        <Route path= "/AdminFunctions" element={<AdminFunctions />}></Route>
        
        
      </Routes>
    </Router>
      

    </div>    
  );
}

export default App;

