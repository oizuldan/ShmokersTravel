import React, { useEffect, useState } from "react";
import { useCookies } from "react-cookie";
import { useHistory } from "react-router-dom";

import "./index.css";
import Button from "../../components/Button";
import BuyForm from "../../components/BuyForm";

// const seats = [1, 4, 5, 7];

// const location = {
//   res: {
//     departureTrainStationName: "Nur-Sultan",
//     arrivalTrainStationName: "Almaty",
//     departureDateTime: new Date(),
//     arrivalDateTime: new Date(),
//     avlbSeats: 100,
//     id: "125NM",
//     price: 10000
//   },
//   passengers: 2
// };

const checkEmptyTickets = tickets => {
  for (let i = 0; i < tickets.length; i++) {
    if (Object.entries(tickets[i]).length === 0) {
      return false;
    }
  }
  return true;
};

const checkSameSeats = tickets => {
  const seats = [];
  for (let i = 0; i < tickets.length; i++) {
    if (seats.indexOf(tickets[i].seat) !== -1) {
      return false;
    }
    seats.push(tickets[i].seat);
  }
  return true;
};

const BuyTicket = ({ location }) => {
  const { arrCity, depCity, passengers, res, result } = location.state;
  const [cookies] = useCookies();
  const history = useHistory();
  let vagonNumber = result[0][1];
  let trainNumber = result[0][0];
  let price = res[2];

  const tickets = new Array(Number(passengers));
  tickets.fill({});

  const onBuyClick = () => {
    if (checkEmptyTickets(tickets)) {
      if (checkSameSeats(tickets)) {
        tickets.forEach(async ticket => {
          await fetch("http://localhost:8080/createTicket", {
            method: "POST",
            headers: { "Content-type": "application/json" },
            body: JSON.stringify({
              hash: cookies.isAuthorized,
              price,
              vagonNumber,
              trainNumber,
              departureTrainStationName: depCity,
              arrivalTrainStationName: arrCity,
              seatNumber: ticket.seat,
              tripId: res[0],
              fromStation: result[0][6],
              toStation: result[0][5],
              passengerFirstName: ticket.firstName,
              passengerSecondName: ticket.secondName,
              arrivalDate: res[4],
              departureDate: res[3]
            })
          });
        });
        alert(
            "Tickets were successfully ordered, you can see them on profile page"
        );
        history.push({
          pathname: "/"
        });
      } else alert("Some of the passengers have same seats");
    } else alert("One or more passengers were not confirmed");
  };

  return (
    <div className="buy-ticket">
      <h1>
        {depCity} - {arrCity}
      </h1>
      {result &&
        tickets.map((form, index) => (
          <div key={index}>
            <b>Passenger #{index + 1}</b>
            <BuyForm result={result} tickets={tickets} index={index} />
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
