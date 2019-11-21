import React, { useState } from "react";
import Ticket from "../../components/ticket";
import Workers from "../../components/Workers";

import "./index.css";
import Button from "../../components/Button";
import Routes from "../../components/Routes";
import TicketModal from "../../components/TicketModal";
import Settings from "../../components/Settings";

const Profile = () => {
  const [showWorkers, setShowWorkers] = useState(false);
  const [showRoutes, setShowRoutes] = useState(false);
  const [showTickets, setShowTickets] = useState(false);
  const [showSettings, setShowSettings] = useState(false);

  const [firstName, setFirstName] = useState("Nursultan");
  const [secondName, setSecondName] = useState("Akhmetzhanov");
  const [email] = useState("nurs@gmail.com");
  const [phone, setPhone] = useState("123456789");

  return (
    <div>
      <div className="profile">
        <h1 className="profile-title">
          Profile
          <span
            className="profile-settings"
            onClick={() => setShowSettings(true)}
          >
            Profile Settings
          </span>
        </h1>

        <div className="profile-row">
          <div className="profile-key">First Name:</div>
          <div className="profile-value">{firstName}</div>
        </div>
        <div className="profile-row">
          <div className="profile-key">Last Name:</div>
          <div className="profile-value">{secondName}</div>
        </div>
        <div className="profile-row">
          <div className="profile-key">Email:</div>
          <div className="profile-value">{email}</div>
        </div>
        <div className="profile-row">
          <div className="profile-key">Phone:</div>
          <div className="profile-value">{phone}</div>
        </div>
        <div className="profile-buttons">
          <Button
            text="Show Workers"
            className="profile-button"
            onClick={() => setShowWorkers(true)}
          />
          <Button
            text="Manage Routes"
            className="profile-button"
            onClick={() => setShowRoutes(true)}
          />
          <Button
            text="Manage Tickets"
            className="profile-button"
            onClick={() => setShowTickets(true)}
          />
        </div>
      </div>
      <Ticket />

      <Workers
        show={showWorkers}
        workers={workers}
        onHide={() => setShowWorkers(false)}
      />
      <Routes
        show={showRoutes}
        workers={workers}
        onHide={() => setShowRoutes(false)}
      />
      <TicketModal
        show={showTickets}
        workers={workers}
        onHide={() => setShowTickets(false)}
      />
      <Settings
        onHide={() => setShowSettings(false)}
        show={showSettings}
        firstName={firstName}
        secondName={secondName}
        phone={phone}
        setFirstName={setFirstName}
        setSecondName={setSecondName}
        setPhone={setPhone}
      />
    </div>
  );
};

const workers = [
  {
    id: 1,
    firstName: "Nurs",
    secondName: "Akhmetzhanov",
    salary: 9
  },
  {
    id: 2,
    firstName: "Nurs",
    secondName: "Akhmetzhanov",
    salary: 9
  },
  {
    id: 3,
    firstName: "Nurs",
    secondName: "Akhmetzhanov",
    salary: 9
  },
  {
    id: 4,
    firstName: "Nurs",
    secondName: "Akhmetzhanov",
    salary: 9
  },
  {
    id: 5,
    firstName: "Nurs",
    secondName: "Akhmetzhanov",
    salary: 9
  }
];

export default Profile;
