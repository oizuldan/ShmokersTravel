import React, {useState} from 'react';

import SearchForm from "../../components/SearchForm";
import ResultTable from "../../components/ResultTable";

import './index.css';

const Main = () => {

    const [showResults, setShowResults] = useState(false);

    return <div className="main">
        <div className="vertically-centered">
            {showResults ?
                <ResultTable/> :
                <>
                    <SearchForm/>
                    <div className="promo-text">
                        Plan your vacation to the most beautiful <br/> places of Kazakhstan
                    </div>
                </>}
        </div>
    </div>
};

export default Main;