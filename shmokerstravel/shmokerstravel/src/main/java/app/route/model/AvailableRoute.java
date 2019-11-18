package app.route.model;

import javax.persistence.*;

@Entity
@Table(name = "AvailableRoute")
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

    public AvailableRoute() {}

    public AvailableRoute(int numberOfAvailableSeats,
                          int ticketPrice,
                          int routeId,
                          int fromStation,
                          int toStation) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.ticketPrice = ticketPrice;
        this.routeId = routeId;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public int getNumberOfAvailableSeats() {return numberOfAvailableSeats;}

    public int getTicketPrice() {return ticketPrice;}

    public int getRouteId() {return routeId;}

    public int getFromStation() {return fromStation;}

    public int getToStation() {return toStation;}

    @Override
    public String toString() {
        return "AvailableRoute{" +
                "routeId='" + routeId + "\'" +
                "numberOfAvailableSeats='" + numberOfAvailableSeats + "\'" +
                "ticketPrice='" + ticketPrice + "\'" +
                "fromStation='" + fromStation + "\'" +
                "toStation='" + toStation + "\'" +
                "}";
    }
}
