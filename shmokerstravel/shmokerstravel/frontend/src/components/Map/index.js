import React from "react";
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  Marker
} from "react-google-maps";

const Map = withScriptjs(
  withGoogleMap(({ isMarkerShown, stations, onStationClick }) => (
    <GoogleMap defaultZoom={5.89} defaultCenter={{ lat: 53.546621, lng: 72.2754364 }}>
      {isMarkerShown &&
        stations.map(station => (
          <Marker
            key={station.name}
            position={{ lat: station.location[0], lng: station.location[1] }}
            onClick={() => onStationClick(station.name)}
          />
        ))}
    </GoogleMap>
  ))
);

export default Map;
