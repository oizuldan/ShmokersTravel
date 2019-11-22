import React, { useState, useEffect } from "react";
import { useCookies } from "react-cookie";

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
  const [password, setPassword] = useState("");
  const [tickets, setTickets] = useState([]);

  const [cookies, setCookie] = useCookies();
  const [isAgent, setAgent] = useState(false);
  const [isManager, setManager] = useState(false);

  const [firstName, setFirstName] = useState("");
  const [secondName, setSecondName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch(`http://localhost:8080/user/${cookies.isAuthorized}`);
      const result = await response.json();
      setFirstName(result.firstName);
      setSecondName(result.lastName);
      setEmail(result.email);
      setPhone(result.phone);
      setPassword(result.password)

      const response2 = await fetch(`http://localhost:8080/getAgents`);
      const result2 = await response2.json();
      result2.forEach(res => {
        if(res.employeeId === result.id)
          setCookie(isAgent, true, {path: '/'});
      });

      const response3 = await fetch(`http://localhost:8080/getTickets/${result.id}`);
      const result3 = await response3.json();
      setTickets(result3);
    };
    fetchData();
  }, []);

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
          {cookies.isManager === "true" && <Button
            text="Show Workers"
            className="profile-button"
            onClick={() => setShowWorkers(true)}
          />}
          {cookies.isManager === "true" && <Button
            text="Manage Routes"
            className="profile-button"
            onClick={() => setShowRoutes(true)}
          />}
          {cookies.isAgent === "true" && <Button
            text="Manage Tickets"
            className="profile-button"
            onClick={() => setShowTickets(true)}
          />}
        </div>
      </div>
      {tickets.map((ticket, index) => <Ticket key={index} ticket={ticket}/>)}

      <Workers
          show={showWorkers}
          workers={workers}
          onHide={() => setShowWorkers(false)}
      />
      <Routes
          show={showRoutes}
          onHide={() => setShowRoutes(false)}
      />
      <TicketModal
          show={showTickets}
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
        hash={cookies.isAuthorized}
        email={email}
        setEmail={setEmail}
        password={password}
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
