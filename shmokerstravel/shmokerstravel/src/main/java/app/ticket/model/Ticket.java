package app.ticket.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "date")
    private Date date;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "departure_train_station_name")
    private String departureTrainStationName;

    @Column(name = "arrival_train_station_name")
    private String arrivalTrainStationName;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "train_number")
    private int trainNumber;

    @Column(name = "vagon_number")
    private int vagonNumber;

    @Column(name = "passenger_first_name")
    private String passengerFirstName;

    @Column(name = "passenger_last_name")
    private String passengerLastName;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    public Ticket(int price, Date date, String userId, String departureTrainStationName, String arrivalTrainStationName,
                  int seatNumber, int trainNumber, String passengerFirstName, String passengerLastName, int vagonNumber,
                  Date arrivalDate, Date departureDate) {
        this.price = price;
        this.date = date;
        this.userId = userId;
        this.departureTrainStationName = departureTrainStationName;
        this.arrivalTrainStationName = arrivalTrainStationName;
        this.seatNumber = seatNumber;
        this.trainNumber = trainNumber;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.vagonNumber = vagonNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public int getId(){return id;}

    public int getPrice(){return price;}

    public int getSeatNumber(){return seatNumber;}

    public int getTrainNumber(){return trainNumber;}

    public Date getArrivalDate(){return arrivalDate;}

    public Date getDepartureDate(){return departureDate;}

    public String getDepartureTrainStationName(){return departureTrainStationName;}

    public String getArrivalTrainStationName(){return arrivalTrainStationName;}

    public String getPassengerFirstName(){return passengerFirstName;}

    public String getPassengerLastName(){return passengerLastName;}

    public String getUserId(){return userId;}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + passengerFirstName + '\'' +
                ", lastName='" + passengerLastName + '\'' +
                ", departureStation='" + departureTrainStationName + '\'' +
                ", arrivalStation='" + arrivalTrainStationName + '\'' +
                ", train='" + trainNumber + '\'' +
                ", vagon='" + vagonNumber + '\'' +
                ", seat='" + seatNumber + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                '}';
    }
}
