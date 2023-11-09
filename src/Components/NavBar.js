import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav } from 'react-bootstrap';
import './NavBar.css';

function CustomNavbar() {
  return (
      <Navbar variant="light" expand="lg" className="custom-navbar">
        <Navbar.Brand href="/" className="LogoDiv"><h1><strong>CarWash...</strong></h1></Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
          <Nav className="mr-auto">
            <Nav.Link href="/" className="Home">Home</Nav.Link>
            <Nav.Link href="#profile" className="Profile">Profile</Nav.Link>
            <Nav.Link href="/AllCustomers" className="Account">Account</Nav.Link>
            <Nav.Link href="#business" className="Business">Business</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
  );
}

export default CustomNavbar;
