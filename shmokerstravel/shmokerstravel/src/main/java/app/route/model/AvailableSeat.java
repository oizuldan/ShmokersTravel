package app.route.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "available_seat")
@IdClass(AvailableSeatKeys.class)
public class AvailableSeat {

    @Id
    @Column(name = "from_station")
    private int fromStation;

    @Id
    @Column(name = "to_station")
    private int toStation;

    @Id
    @Column(name = "trip_id")
    private int tripId;

    @Id
    @Column(name = "ticket_price")
    private int ticketPrice;

    @Id
    @Column(name = "seat_number")
    private int seatNumber;

    @Id
    @Column(name = "train_number")
    private int trainNumber;

    @Id
    @Column(name = "vagon_number")
    private int vagonNumber;

    @Id
    @Column(name = "date")
    private Date date;

    public AvailableSeat() {}

    public AvailableSeat(int ticketPrice,
                          int tripId,
                          int fromStation,
                          int toStation,
                          int seatNumber,
                          int vagonNumber,
                          int trainNumber,
                          Date date
    ) {
        this.ticketPrice = ticketPrice;
        this.tripId = tripId;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.seatNumber = seatNumber;
        this.vagonNumber = vagonNumber;
        this.trainNumber = trainNumber;
        this.date = date;
    }


    public int getTicketPrice() {return ticketPrice;}

    public int getTripId() {return tripId;}

    public int getFromStation() {return fromStation;}

    public int getToStation() {return toStation;}

    public int getVagonNumber() {return vagonNumber;}

    public int getSeatNumber() {return seatNumber;}

    public int getTrainNumber() {return trainNumber;}

    public Date getDate() { return date;}

    public void setToStation(int toStation) {
        this.toStation = toStation;
    }

    public void setFromStation(int fromStation) {
        this.fromStation = fromStation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setVagonNumber(int vagonNumber) {
        this.vagonNumber = vagonNumber;
    }

    @Override
    public String toString() {
        return "AvailableSeat{" +
                "tripId='" + tripId + "\'" +
                "seatNumber='" + seatNumber + "\'" +
                "vagonNumber='" + vagonNumber + "\'" +
                "trainNumber='" + trainNumber + "\'" +
                "ticketPrice='" + ticketPrice + "\'" +
                "fromStation='" + fromStation + "\'" +
                "toStation='" + toStation + "\'" +
                "date='" + date + "\'" +
                "price='" + ticketPrice +'\'' +
                "}";
    }
}
