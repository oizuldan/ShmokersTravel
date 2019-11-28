import React from "react";
import {useHistory} from 'react-router-dom'
import "./index.css";
import {format} from "date-fns"

const Ticket = ({
  ticket
}) => {
    const {arrivalDate,
        arrivalTrainStationName,
        departureDate,
        departureTrainStationName,
        passengerFirstName,
        passengerLastName,
        price,
        seatNumber,
        trainNumber,
        vagonNumber, id} = ticket;

    const history = useHistory();

    const returnTicket = async() => {
        await fetch(`http://localhost:8080/deleteTrip/${id}`, {
            method: "DELETE",
            headers: { "Content-type": "application/json" },
        });
        history.push({pathname:"/profile"})
    };
  return (
    <div>
      <div className="the-main-ticket">
        <div className="ticket-train">
          <div className="ticket-text">
            Ticket: <span className="ticket-number">{id}</span>
          </div>
          <div className="ticket-text">
            Train: <span className="train-number">{trainNumber}</span>
          </div>
          <div className="ticket-text">
            Seat: <span className="seat-number">{seatNumber}</span>
          </div>
          <div className="ticket-text">
            Vagon: <span className="vagon-number">{vagonNumber}</span>
          </div>
          <div className="ticket-text">
            Price: <span className="ticket-price">{price} tg</span>
          </div>
            {departureDate > new Date().getTime() &&
                <div className="route-change-state" onClick={returnTicket}>
                    Return ticket
                </div>
            }
        </div>
        <div className="ticket-route">
          <div className="ticket-time">
            <div className="ticket-time-c">
              <div className="ticket-text">
                  {format(departureDate, 'HH:mm')},{' '}{departureTrainStationName}
              </div>
              <div className="ticket-time-mm">
                {format(departureDate, 'MMMM dd')}
              </div>
            </div>
            <hr className="line" />
            <div className="ticket-time-c">
              <div className="ticket-text">
                {format(arrivalDate, 'HH:mm')},{' '}{arrivalTrainStationName}
              </div>
              <div className="ticket-time-mm">
                {format(arrivalDate, 'MMMM dd')}
              </div>
            </div>
          </div>
          <hr className="line2" />
          <div className="ticket-owner">
            <div className="ticket-text">
              Name: <span className="text-name">{passengerFirstName} </span>
            </div>
            <div className="ticket-text">
              Surname: <span className="text-surname">{passengerLastName}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Ticket;
