package app.route.model;

import javax.persistence.*;

@Entity
@Table(name = "available_route")
@IdClass(AvailableRouteKeys.class)
public class AvailableRoute {

    @Id
    @Column(name = "from_station")
    private int fromStation;

    @Id
    @Column(name = "to_station")
    private int toStation;

    @Id
    @Column(name = "route_id")
    private int routeId;

    @Id
    @Column(name = "available_seats")
    private int numberOfAvailableSeats;

    @Id
    @Column(name = "ticket_price")
    private int ticketPrice;

    @Id
    @Column(name = "seat_number")
    private int seatNumber;

    @Id
    @Column(name = "vagon_number")
    private int vagonNumber;

    public AvailableRoute() {}

    public AvailableRoute(int ticketPrice,
                          int routeId,
                          int fromStation,
                          int toStation,
                          int seatNumber,
                          int vagonNumber) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.ticketPrice = ticketPrice;
        this.routeId = routeId;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.seatNumber = seatNumber;
        this.vagonNumber = vagonNumber;
    }

    public int getNumberOfAvailableSeats() {return numberOfAvailableSeats;}

    public int getTicketPrice() {return ticketPrice;}

    public int getRouteId() {return routeId;}

    public int getFromStation() {return fromStation;}

    public int getToStation() {return toStation;}

    public int getVagonNumber() {return vagonNumber;}

    @Override
    public String toString() {
        return "AvailableRoute{" +
                "routeId='" + routeId + "\'" +
                "seatNumber='" + seatNumber + "\'" +
                "vagonNumber='" + vagonNumber + "\'" +
                "numberOfAvailableSeats='" + numberOfAvailableSeats + "\'" +
                "ticketPrice='" + ticketPrice + "\'" +
                "fromStation='" + fromStation + "\'" +
                "toStation='" + toStation + "\'" +
                "}";
    }
}
