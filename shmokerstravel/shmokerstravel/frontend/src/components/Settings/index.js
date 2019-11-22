import React, { useState } from "react";
import Modal from "react-bootstrap/Modal";

import Button from "../Button";

const Settings = ({
  show,
  firstName,
  secondName,
  phone,
  setFirstName,
  setSecondName,
  setPhone,
  onHide,
  hash,
  email,
  setEmail,
  password
}) => {
  const checkUser = async () => {
    await fetch("http://localhost:8080/user/update", {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify({
        hash,
        password,
        phone,
        email,
        firstName,
        lastName: secondName
      })
    });
    onHide();
  };

  return (
    <Modal show={show} className="modal" onHide={onHide}>
      <Modal.Body>
        <div className="modal-title">Profile Settings</div>
        <div className="input-container">
          <span className="input-placeholder">First Name:</span>
          <input
            type="text"
            className="input-field"
            onChange={e => setFirstName(e.target.value)}
            value={firstName}
          />
        </div>
        <div className="input-container">
          <span className="input-placeholder">Last Name:</span>
          <input
            type="text"
            className="input-field"
            onChange={e => setSecondName(e.target.value)}
            value={secondName}
          />
        </div>
        <div className="input-container">
          <span className="input-placeholder">Email:</span>
          <input
            type="text"
            className="input-field"
            value={email}
            onChange={e => setEmail(e.target.value)}
          />
        </div>
        <div className="input-container">
          <span className="input-placeholder">Phone:</span>
          <input
            type="text"
            className="input-field"
            value={phone}
            onChange={e => setPhone(e.target.value)}
          />
        </div>
        <Button className="input-button" onClick={checkUser} text="Submit" />
      </Modal.Body>
    </Modal>
  );
};

export default Settings;
