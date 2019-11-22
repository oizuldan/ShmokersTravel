import React, { useState } from "react";

import "./index.css";
import { stations } from "../../constants/stations";
import Button from "../../components/Button";
import Map from "../../components/Map";
import ScheduleModal from "../../components/Schedule";

const Schedule = () => {
  const [station, setStation] = useState(stations[0].name);
  const [showMap, setShowMap] = useState(false);
  const [results, setResults] = useState([]);
  const [showModal, setShowModal] = useState(false);

  const onClick = async () => {
    const response = await fetch(
        `http://localhost:8080/tripsOnStation?name=${station}`
    );
    const result = await response.json();
    setResults(result);
    setShowModal(true);
  };

  return (
    <div className="schedule-main">
      <h1>Schedule by station</h1>
      <div>
        <div>
          <span>Select station</span>
          <select
            value={station}
            onChange={e => setStation(e.target.value)}
            className="station-select"
          >
            {stations.map(station => (
              <option key={station.name}>{station.name}</option>
            ))}
          </select>
          or <span className="select-map" onClick={() => setShowMap(true)}>Select from map</span>
        </div>
        {showMap && (
          <Map
            isMarkerShown
            googleMapURL="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=geometry,drawing,places&language=en"
            loadingElement={<div style={{ height: `100%` }} />}
            containerElement={<div style={{ height: `400px`, marginTop: '20px' }} />}
            mapElement={<div style={{ height: `100%` }} />}
            stations={stations}
            onStationClick={(station) => setStation(station)}
          />
        )}
        <Button text="Show schedule" className="schedule-button" onClick={onClick}/>
      </div>

      <ScheduleModal show={showModal} onHide={() => setShowModal(false)} results={results} station={station}/>
    </div>
  );
};

export default Schedule;
