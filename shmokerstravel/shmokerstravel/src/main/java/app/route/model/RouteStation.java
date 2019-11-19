package app.route.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "route_station")
public class RouteStation {

    @Column(name = "route_id")
    private int routeId;

    @Id
    @Column(name = "station_index")
    private int stationIndex;

    @Column(name = "train_station_name")
    private String trainStationName;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    public RouteStation() {}

    public RouteStation(
            int routeId,
            int stationIndex,
            String stationName,
            Date arrivalDate,
            Date departureDate) {
        this.routeId = routeId;
        this.stationIndex = stationIndex;
        this.trainStationName = stationName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public int getRouteId() { return routeId;}

    public int getStationIndex() { return stationIndex;}

    public String getStationName() { return trainStationName;}

    public Date getArrivalDate() { return arrivalDate;}

    public Date getDepartureDate() { return departureDate;}

    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                "stationIndex='" + stationIndex + "\'" +
                "stationName='" + trainStationName + "\'" +
                "arrivalDate='" + arrivalDate + '\'' +
                "departureDate='" + departureDate + '\'' +
                '}';
    }
}