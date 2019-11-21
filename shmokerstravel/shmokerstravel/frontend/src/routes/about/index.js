import React from 'react';
import Cards from '../about/cards'
import "./index.css";
const About = () => {


return (
    <div>
        <div className = "about">
            <h2>About</h2>
            <p>This project was created for Software Engineering and Database Systems classes. </p>
        </div>
        <Cards />
    </div>
    )
};

export default About;