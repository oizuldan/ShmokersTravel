import React from 'react';
import {format} from "date-fns";

import Button from "../../Button";

import './index.css';

const ResultInfo = ({res}) => {
    return (<div className="result-info">
        <div className="result-train">
            <div className="result-text">
                {res.depCity} - {res.arrCity}
            </div>
            <div className="result-text">Train # {res.train}</div>
        </div>
        <div className="result-time">
            <div className="result-time-c">
                <div className="result-text">
                    {format(res.depTime, 'HH:mm')}, {res.depCity}
                </div>
                <div className="result-time-mm">{format(res.depTime, 'MMMM dd')}</div>
            </div>
            <hr/>
            <div className="result-time-c">
                <div className="result-text">
                    {format(res.arrTime, 'HH:mm')}, {res.arrCity}
                </div>
                <div className="result-time-mm">{format(res.arrTime, 'MMMM dd')}</div>
            </div>
        </div>
        <div className="result-seat">
            <div className="result-text">
                Available seats: <span className="seats-number">{res.avlbSeats}</span>
            </div>
            <div className="result-text">
                Price: <span className='seat-price'>{res.price}tg</span>
            </div>
            <Button className="buy-button" text="Buy" type="additional"/>
        </div>
    </div>)
};

export default ResultInfo;