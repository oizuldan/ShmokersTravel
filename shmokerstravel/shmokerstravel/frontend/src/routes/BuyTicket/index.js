import React, { useState } from "react";

import "./index.css";
import Button from "../../components/Button";
import BuyForm from "../../components/BuyForm";

const seats = [1, 4, 5, 7];

const location = {
  res: {
    departureTrainStationName: "Nur-Sultan",
    arrivalTrainStationName: "Almaty",
    departureDateTime: new Date(),
    arrivalDateTime: new Date(),
    avlbSeats: 100,
    id: "125NM",
    price: 10000
  },
  passengers: 2
};

const checkEmptyTickets = tickets => {
  for (let i = 0; i < tickets.length; i++) {
    if (Object.entries(tickets[i]).length === 0) return false;
  }
  return true;
};

const BuyTicket = () => {
  const { arrivalTrainStationName, departureTrainStationName } = location.res;
  const { passengers } = location;

  const tickets = new Array(passengers);
  tickets.fill({});

  const onBuyClick = () => {
    if (checkEmptyTickets(tickets)) {
      console.log(tickets);
    } else alert("One or more passengers were not confirmed");
  };

  return (
    <div className="buy-ticket">
      <h1>
        {departureTrainStationName} - {arrivalTrainStationName}
      </h1>
      {tickets.map((form, index) => (
        <div key={index}>
          <b>Passenger #{index + 1}</b>
          <BuyForm seats={seats} tickets={tickets} index={index} />
        </div>
      ))}
      <Button
        type="additional"
        text={"Buy"}
        className="buy-ticket-button"
        onClick={onBuyClick}
      />
    </div>
  );
};

export default BuyTicket;
