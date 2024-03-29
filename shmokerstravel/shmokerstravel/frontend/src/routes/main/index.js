import React, { useState } from "react";

import SearchForm from "../../components/SearchForm";
import ResultTable from "../../components/ResultTable";

import "./index.css";

// const resultsMock = [
//   {
//     departureTrainStationName: "Nur-Sultan",
//     arrivalTrainStationName: "Almaty",
//     departureDateTime: new Date(),
//     arrivalDateTime: new Date(),
//     avlbSeats: 100,
//     id: "125NM",
//     price: 10000
//   },
//   {
//     departureTrainStationName: "Nur-Sultan",
//     arrivalTrainStationName: "Almaty",
//     departureDateTime: new Date(),
//     arrivalDateTime: new Date(),
//     avlbSeats: 100,
//     id: "125NM",
//     price: 10040
//   }
// ];

const Main = () => {
  const [showResults, setShowResults] = useState(false);
  const [date, setDate] = useState(new Date());
  const [departure, setDeparture] = useState("");
  const [arrival, setArrival] = useState("");
  const [results, setResult] = useState([]);
  const [passengers, setPassengers] = useState(1);

  const onSearchClick = async () => {
    const depDate = date;
    depDate.setHours(0 ,0, 0, 0);
    const arrDate = new Date(date);
    arrDate.setHours(23, 59, 0, 0);
    const response = await fetch(
      `http://localhost:8080/availableTrip?from=${departure.trim()}&to=${arrival.trim()}&date=${depDate.getTime()}&dateLimit=${arrDate.getTime()}`
    );
    const result = await response.json();
    setResult(result);
    setShowResults(true);
  };

  const onBackClick = () => {
    setShowResults(false);
    setDeparture("");
    setArrival("");
  };

  return (
    <div className="main">
      <div className="vertically-centered">
        {showResults ? (
          <ResultTable
            depCity={departure}
            arrCity={arrival}
            date={date}
            passengers={passengers}
            onClick={onBackClick}
            results={results}
          />
        ) :  (
          <>
            <SearchForm
              setArrival={setArrival}
              setDate={setDate}
              setDeparture={setDeparture}
              setPassengers={setPassengers}
              date={date}
              onClick={onSearchClick}
              disabled={!departure.length || !arrival.length}
            />
            <div className="promo-text">
              Plan your vacation to the most beautiful <br /> places of
              Kazakhstan
            </div>
          </>
        )}
      </div>
    </div>
  );
};

export default Main;
