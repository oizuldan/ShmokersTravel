import React, {useState, useEffect} from 'react';
import { useCookies } from 'react-cookie';
import {Link} from "react-router-dom";

import Login from "../Login";
import SignUp from "../SignUp";

import './index.css';

const NavBar = () => {
    const [showLogin, setShowLogin] = useState(false);
    const [showSignUp, setShowSignUp] = useState(false);
    const [isMobile, setIsMobile] = useState(false);

    const [cookies, setCookie] = useCookies(['isAuthorized']);
    const [isAuthorized, setIsAuthorized] = useState(false);

    const logIn = () => {
        setCookie('isAuthorized', true, {path: '/'});
        setIsAuthorized(true);
    };

    const logOut = () => {
        setCookie('isAuthorized', false, {path: '/'});
        setIsAuthorized(false);
    };

    useEffect(() => {
        cookies.isAuthorized === "true" && logIn();
    });

    return <nav className="navbar">
        <ul className={isMobile ? "responsive-menu" : "menu"} onClick={() => isMobile && setIsMobile(false)}>
            <li className="menu-item"><Link to="about" className="link" >About</Link></li>
            <li className="menu-item">Promos</li>
            <Link to={''} className="link">
                <h1 className="logo" >Shmokers Travel</h1>
            </Link>
            {isAuthorized ? <><Link to="profile" className="link" >Profile</Link>
                    <li className="menu-item" onClick={logOut}>Log Out</li></> :
                <><li className="menu-item" onClick={() => setShowSignUp(true)}>Sign Up</li>
                <li className="menu-item" onClick={() => setShowLogin(true)}>Log In</li></>
            }
        </ul>
        <Link to={''} className='link'><h1 className="logo mobile" >Shmokers Travel</h1></Link>
        <div className="hamburger" onClick={() => setIsMobile(!isMobile)}>
            <hr/>
            <hr/>
            <hr/>
        </div>

        <Login handleClose={() => setShowLogin(false)} show={showLogin} logIn={logIn}/>
        <SignUp handleClose={() => setShowSignUp(false)} show={showSignUp} logIn={logIn}/>
    </nav>
};

export default NavBar;