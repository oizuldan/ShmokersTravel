package app.available_seat.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "available_seat")
public class AvailableSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "vagon_number")
    private int vagonNumber;

    @Column(name = "train_number")
    private int trainNumber;

    @Column(name = "trip_id")
    private int tripId;

    @Column(name = "to_station")
    private int toStation;

    @Column(name = "from_station")
    private int fromStation;

    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    public AvailableSeat(int seatNumber, int vagonNumber, int trainNumber, int tripId,
                         int toStation, int fromStation, int ticketPrice,
                         Date arrivalDate, Date departureDate) {
        this.seatNumber = seatNumber;
        this.vagonNumber = vagonNumber;
        this.trainNumber = trainNumber;
        this.tripId = tripId;
        this.toStation = toStation;
        this.fromStation = fromStation;
        this.ticketPrice = ticketPrice;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Available Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", vagonNumber='" + vagonNumber + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", tripId='" + tripId + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                '}';
    }
}
