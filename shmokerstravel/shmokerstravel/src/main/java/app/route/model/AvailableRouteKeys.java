package app.route.model;

import java.io.Serializable;

public class AvailableRouteKeys implements Serializable {
    private int numberOfAvailableSeats;
    private int routeId;
    private int fromStation;
    private int toStation;
    private int ticketPrice;
}
