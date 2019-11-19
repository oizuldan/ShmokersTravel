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
        {results.map((res, index) => (
          <ResultInfo
            res={{ ...res, passengers }}
            key={index}
            passengers={passengers}
          />
        ))}
      </div>
    </div>
  );
};

export default ResultTable;
