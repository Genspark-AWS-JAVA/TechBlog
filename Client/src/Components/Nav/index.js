import React from "react";
import Nav from "react-bootstrap/Nav"

const Navbar = () => {
    return(
        <div>
            <Nav>
                <Nav.Item>
                    <Nav.Link href="/">Posts</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/login">Login</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link>Account</Nav.Link>
                </Nav.Item>
            </Nav>
        </div>
    )
}

export default Navbar