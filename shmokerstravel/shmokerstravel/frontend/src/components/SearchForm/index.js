import React from 'react';

import SearchItem from "./SearchItem";
import Button from "../Button";

import './index.css';

const SearchForm = ({setDeparture, setArrival, setPassengers, setDate, date, onClick, disabled}) => {

    return <div className="search-form">
        <div className="search-text">Book your journey</div>
        <div className="but-container">
            <div className="search-container">
                <SearchItem placeholder="From" type="text" onChange={e => setDeparture(e.target.value)}/>
                <SearchItem placeholder="To" type="text" onChange={e => setArrival(e.target.value)}/>
                <SearchItem placeholder="Departure" type="date" startDate={date} onChange={date => setDate(date)}/>
                <SearchItem placeholder="Passengers" type="passenger" onChange={e => setPassengers(e.target.value)}/>
            </div>
            <Button className="but-wrapper" text="Search" onClick={onClick} disabled={disabled}/>
        </div>
    </div>
};

export default SearchForm;