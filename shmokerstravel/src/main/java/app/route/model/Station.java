package app.route.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Station")
public class Station {

    @Column(name = "route_id")
    private int routeId;

    @Id
    @Column(name = "station_index")
    private int stationIndex;

    @Column(name = "train_station_name")
    private String stationName;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    public Station() {}

    public Station(
            int routeId,
            int stationIndex,
            String stationName,
            Date arrivalDate,
            Date departureDate) {
        this.routeId = routeId;
        this.stationIndex = stationIndex;
        this.stationName = stationName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public int getRouteId() { return routeId;}

    public int getStationIndex() { return stationIndex;}

    public String getStationName() { return stationName;}

    public Date getArrivalDate() { return arrivalDate;}

    public Date getDepartureDate() { return departureDate;}

    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                "stationIndex='" + stationIndex + "\'" +
                "stationName='" + stationName + "\'" +
                "arrivalDate='" + arrivalDate + '\'' +
                "departureDate='" + departureDate + '\'' +
                '}';
    }
}