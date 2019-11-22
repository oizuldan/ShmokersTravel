import React from "react";
import { format } from "date-fns";

import Button from "../Button";
import ResultInfo from "./ResultInfo";

import "./index.css";

const ResultTable = ({
  depCity,
  arrCity,
  date,
  onClick,
  results,
  passengers
}) => {
  return (
    <div className="result-table">
      <div className="result-header">
        <span className="search-info">
          {depCity} - {arrCity}, {format(date, "MMMM dd")}
        </span>
        <Button
          className="search-info-button"
          text="Return to search"
          onClick={onClick}
        />
      </div>
      <div className="results">
        {results.filter(res => res[1] >= Number(passengers)).length ? results.map((res, index) => (
          <ResultInfo
            res={res}
            key={index}
            passengers={passengers}
            depCity={depCity}
            arrCity={arrCity}
          />
        )) : <h2>No results found</h2>}
      </div>
    </div>
  );
};

export default ResultTable;
