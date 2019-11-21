import React, {useState} from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import {CookiesProvider} from 'react-cookie';

import About from '../../routes/about'
import Main from '../../routes/main'
import Profile from '../../routes/profile'
import NavBar from "../NavBar";
import BuyTicket from "../../routes/BuyTicket";
import Schedule from "../../routes/Schedule";

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {

    return (
      <CookiesProvider>
        <div className="backimage">
            <Router>
                <NavBar />
                <Switch>
                    <Route path="/" exact component={Main}/>
                    <Route path="/about" component={About}/>
                    <Route path="/profile" component={Profile}/>
                    <Route path="/buy" component={BuyTicket}/>
                    <Route path="/schedule" component={Schedule}/>
                </Switch>
            </Router>
        </div>
      </CookiesProvider>
  );
}


export default App;
