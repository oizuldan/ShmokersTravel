package app.route.model;

import java.io.Serializable;
import java.util.Date;

public class AvailableSeatKeys implements Serializable {
    private int tripId;
    private int fromStation;
    private int toStation;
    private int ticketPrice;
    private int vagonNumber;
    private int trainNumber;
    private int seatNumber;
    private Date date;
}
