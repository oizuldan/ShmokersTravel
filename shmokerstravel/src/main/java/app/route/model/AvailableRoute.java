package app.route.model;

import javax.persistence.*;

@Entity
@Table(name = "AvailableRoute")
@IdClass(AvailableRouteKeys.class)
public class AvailableRoute {

    @Id
    @Column(name = "seat_number")
    private int seatNumber;

    @Id
    @Column(name = "vagon_number")
    private int vagonNumber;

    @Id
    @Column(name = "route_id")
    private int routeId;

    @Id
    @Column(name = "from_station")
    private int fromStation;

    @Id
    @Column(name = "to_station")
    private int toStation;

    @Id
    @Column(name = "train_number")
    private int trainNumber;

    public AvailableRoute() {}

    public AvailableRoute(int seatNumber,
                          int vagonNumber,
                          int routeId,
                          int fromStation,
                          int toStation,
                            int trainNumber) {
        this.seatNumber = seatNumber;
        this.vagonNumber = vagonNumber;
        this.routeId = routeId;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainNumber = trainNumber;
    }

    public int getSeatNumber() {return seatNumber;}

    public int getVagonNumber() {return vagonNumber;}

    public int getRouteId() {return routeId;}

    public int getFromStation() {return fromStation;}

    public int getToStation() {return toStation;}

    @Override
    public String toString() {
        return "AvailableRoute{" +
                "routeId='" + routeId + "\'" +
                "seatNumber='" + seatNumber + "\'" +
                "vagonNumber='" + vagonNumber + "\'" +
                "fromStation='" + fromStation + "\'" +
                "toStation='" + toStation + "\'" +
                "trainNumber='" + trainNumber + "\'" +
                "}";
    }
}
