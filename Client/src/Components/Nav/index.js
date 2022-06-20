import React from "react";
import Nav from "react-bootstrap/Nav"

const Navbar = () => {
    return (
        <div className="headerArea">
            <Nav className="headerArea">
                <Nav.Item className="headerArea">
                    <Nav.Link href="/" className="headerArea">Posts</Nav.Link>
                </Nav.Item>
                <Nav.Item className="headerArea">
                    <Nav.Link href="/search" className="headerArea">Search</Nav.Link>
                </Nav.Item>
                <Nav.Item className="headerArea">
                    <Nav.Link href="/login" className="headerArea">Login</Nav.Link>
                </Nav.Item>
                <Nav.Item className="headerArea">
                    <Nav.Link className="headerArea">Account</Nav.Link>
                </Nav.Item>
            </Nav>
        </div>
    )
}

export default Navbar