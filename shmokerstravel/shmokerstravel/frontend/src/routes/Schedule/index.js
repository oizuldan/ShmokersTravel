import React, { useState } from "react";

import "./index.css";
import { stations } from "../../constants/stations";
import Button from "../../components/Button";
import Map from "../../components/Map";

const Schedule = () => {
  const [station, setStation] = useState(stations[0].name);
  const [showMap, setShowMap] = useState(false);

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
        <Button text="Show schedule" className="schedule-button" />
      </div>
    </div>
  );
};

export default Schedule;
