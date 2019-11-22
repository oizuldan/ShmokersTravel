import React, { useState } from "react";

import "./index.css";
import Button from "../Button";

const BuyForm = ({ result, tickets, index }) => {
  const [firstName, setFirstName] = useState("");
  const [secondName, setSecondName] = useState("");
  const [seat, setSeat] = useState(result[0][2]);
  const [disabled, setDisabled] = useState(false);

  const onConfirmClick = () => {
    if (disabled) setDisabled(false);
    else {
      if (firstName === "" || secondName === "") alert("Fill out all fields");
      else {
        tickets[index] = { firstName, secondName, seat };
        setDisabled(true);
      }
    }
  };

  return (
    <div className="buy-form">
      <div className="buy-form-input-container">
        <span>First Name</span>
        <input
          type="text"
          className="buy-form-input"
          value={firstName}
          onChange={e => setFirstName(e.target.value)}
          spellCheck={false}
          disabled={disabled}
        />
      </div>
      <div className="buy-form-input-container">
        <span>Second Name</span>
        <input
          type="text"
          className="buy-form-input"
          value={secondName}
          onChange={e => setSecondName(e.target.value)}
          spellCheck={false}
          disabled={disabled}
        />
      </div>
      <div className="buy-form-input-container">
        <span>Seat</span>
        <select
          onChange={e => setSeat(e.target.value)}
          value={seat}
          className="buy-form-input"
          disabled={disabled}
        >
          {result.map(res => (
            <option key={res[2]}>{res[2]}</option>
          ))}
        </select>
      </div>
      <Button
        text={disabled ? "Edit" : "Confirm"}
        className="form-confirm"
        onClick={onConfirmClick}
      />
    </div>
  );
};

export default BuyForm;
