import React from "react";
import { Navbar , Nav } from "react-bootstrap";

function AdminNavBar() {
    return (
        <div>
            <div className="DivForNavBar">
      <Navbar variant="light" expand="lg" className="custom-navbar">
        <Navbar.Brand href="/" className="LogoDiv">
          <h1>
            <strong>CarWash...</strong>
          </h1>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav" className="justify-content-end">
          <Nav className="mr-auto">
            <Nav.Link href="/AdminHome" className="CustomerHome">
              Home
            </Nav.Link>
            <Nav.Link href="/AdminFunctions" className="Account">
              Functions
            </Nav.Link>
            {/* <Nav.Link href="/MyCars" className="Cars">
              Cars
            </Nav.Link> */}
            <Nav.Link href="/WasherProfile" className="Profile">
              Profile
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    </div>
        </div>
      );
}

export default AdminNavBar;