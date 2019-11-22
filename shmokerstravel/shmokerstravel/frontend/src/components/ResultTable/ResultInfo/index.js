import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import { useCookies } from "react-cookie";
import { format } from "date-fns";

import Button from "../../Button";

import "./index.css";

const ResultInfo = ({ res, passengers = 1, depCity, arrCity }) => {
  const history = useHistory();
  const [cookies] = useCookies();

  const onBuyClick = async () => {
    if (!cookies.isAuthorized || cookies.isAuthorized === "false")
      alert("To buy ticket you need to log in or sign up");
    else {
      const response = await fetch(`http://localhost:8080/getSeats?tripId=${res[0]}&from=${depCity}&to=${arrCity}&date=${res[3]}&dateLimit=${res[4]}`);
      const result = await response.json();
      history.push({
        pathname: "/buy",
        state: {res, passengers, depCity, arrCity, result}
      });
    }
  };

  return (
    <div className="result-info">
      <div className="result-train">
        <div className="result-text">
          {depCity} - {arrCity}
        </div>
        <div className="result-text">Train # {res[0]}</div>
      </div>
      <div className="result-time">
        <div className="result-time-c">
          <div className="result-text">
            {format(res[3], "HH:mm")},{" "}
            {depCity}
          </div>
          <div className="result-time-mm">
            {format(res[3], "MMMM dd")}
          </div>
        </div>
        <hr />
        <div className="result-time-c">
          <div className="result-text">
            {format(res[4], "HH:mm")},{" "}
            {arrCity}
          </div>
          <div className="result-time-mm">
            {format(res[4], "MMMM dd")}
          </div>
        </div>
      </div>
      <div className="result-seat">
        <div className="result-text">
          Available seats: <span className="seats-number">{res[1]}</span>
        </div>
        <div className="result-text">
          Price: <span className="seat-price">{res[2]}tg</span>
        </div>
        <Button
          className="buy-button"
          text="Buy"
          type="additional"
          onClick={onBuyClick}
        />
      </div>
    </div>
  );
};

export default ResultInfo;
