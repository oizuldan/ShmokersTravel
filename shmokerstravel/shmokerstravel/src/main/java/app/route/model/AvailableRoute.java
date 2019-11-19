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
<<<<<<< HEAD:shmokerstravel/src/main/java/app/route/model/AvailableRoute.java

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
=======

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
>>>>>>> a778ca0de11e04ba9c001abd725abc5e11bc61f8:shmokerstravel/shmokerstravel/src/main/java/app/route/model/AvailableRoute.java
        this.ticketPrice = ticketPrice;
        this.routeId = routeId;
        this.fromStation = fromStation;
        this.toStation = toStation;
<<<<<<< HEAD:shmokerstravel/src/main/java/app/route/model/AvailableRoute.java
        this.seatNumber = seatNumber;
        this.vagonNumber = vagonNumber;
=======
>>>>>>> a778ca0de11e04ba9c001abd725abc5e11bc61f8:shmokerstravel/shmokerstravel/src/main/java/app/route/model/AvailableRoute.java
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
<<<<<<< HEAD:shmokerstravel/src/main/java/app/route/model/AvailableRoute.java
                "seatNumber='" + seatNumber + "\'" +
                "vagonNumber='" + vagonNumber + "\'" +
=======
                "numberOfAvailableSeats='" + numberOfAvailableSeats + "\'" +
>>>>>>> a778ca0de11e04ba9c001abd725abc5e11bc61f8:shmokerstravel/shmokerstravel/src/main/java/app/route/model/AvailableRoute.java
                "ticketPrice='" + ticketPrice + "\'" +
                "fromStation='" + fromStation + "\'" +
                "toStation='" + toStation + "\'" +
                "}";
    }
}
