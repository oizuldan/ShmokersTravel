import React, { useState } from "react";
import Ticket from "../../components/ticket";
import ProfileSettings from "../profile-settings";
import Workers from "../../components/Workers";

import "./index.css";
import Button from "../../components/Button";
import Routes from "../../components/Routes";
import TicketModal from "../../components/TicketModal";

const Profile = () => {
  const [showWorkers, setShowWorkers] = useState(false);
  const [showRoutes, setShowRoutes] = useState(false);
  const [showTickets, setShowTickets] = useState(false);

  return (
    <div>
      <div className="profile">
        <h1 className="profile-title">
          Profile
          <a className="profile-settings" href="profile-settings">
            Profile Settings
          </a>
        </h1>

        <div className="profile-row">
          <div className="profile-key">First Name:</div>
          <div className="profile-value">Nursultan</div>
        </div>
        <div className="profile-row">
          <div className="profile-key">Last Name:</div>
          <div className="profile-value">Nursultan</div>
        </div>
        <div className="profile-row">
          <div className="profile-key">Email:</div>
          <div className="profile-value">Nursultan</div>
        </div>
        <div className="profile-row">
          <div className="profile-key">Phone:</div>
          <div className="profile-value">Nursultan</div>
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
