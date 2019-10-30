import React from 'react';

import SearchForm from "../../components/SearchForm";

import './index.css';

const Main = () => {
    return <div className="main">
        <div className="vertically-centered">
            <SearchForm/>
            <div className="promo-text">
                Plan your vacation to the most beautiful <br/> places of Kazakhstan
            </div>
        </div>
    </div>
};

export default Main;