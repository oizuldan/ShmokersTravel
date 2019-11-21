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

    @Column(name = "user_id")
    private int userId;

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

    @Column(name = "passenger_second_name")
    private String passengerSecondName;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "trip_id")
    private int tripId;

    @Column(name = "from_station")
    private int fromStation;

    @Column(name = "to_station")
    private int toStation;

    public Ticket(){}

    public Ticket(int price, int userId, String departureTrainStationName, String arrivalTrainStationName,
                  int seatNumber, int trainNumber, String passengerFirstName, String passengerLastName, int vagonNumber,
                  Date  arrivalDate, Date departureDate, int tripId, int fromStation, int toStation) {
        this.price = price;
        this.userId = userId;
        this.departureTrainStationName = departureTrainStationName;
        this.arrivalTrainStationName = arrivalTrainStationName;
        this.seatNumber = seatNumber;
        this.trainNumber = trainNumber;
        this.passengerFirstName = passengerFirstName;
        this.passengerSecondName = passengerLastName;
        this.vagonNumber = vagonNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.tripId = tripId;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public int getId(){return id;}

    public int getUserId(){return userId;}

    public int getPrice(){return price;}

    public int getSeatNumber(){return seatNumber;}

    public int getTrainNumber(){return trainNumber;}

    public Date getArrivalDate(){return arrivalDate;}

    public Date getDepartureDate(){return departureDate;}

    public String getDepartureTrainStationName(){return departureTrainStationName;}

    public String getArrivalTrainStationName(){return arrivalTrainStationName;}

    public String getPassengerFirstName(){return passengerFirstName;}

    public String getPassengerLastName(){return passengerSecondName;}

    public int getTripId() {return tripId;}

    public int getVagonNumber() {return vagonNumber;}

    public int getFromStation(){return fromStation;}

    public int getToStation(){return toStation;}

    public void setPrice(int price){this.price = price;}

    public void setVagonNumber(int vagonNumber){this.vagonNumber = vagonNumber;}

    public void setSeatNumber(int seatNumber){this.seatNumber = seatNumber;}

    public void setTrainNumber(int trainNumber){this.trainNumber = trainNumber;}

    public void setArrivalDate(Date arrivalDate){this.arrivalDate = arrivalDate;}

    public void setDepartureDate(Date departureDate){this.departureDate = departureDate;}

    public void setDepartureTrainStationName(String departureTrainStationName){this.departureTrainStationName = departureTrainStationName;}

    public void setArrivalTrainStationName(String arrivalTrainStationName){this.arrivalTrainStationName = arrivalTrainStationName;}

    public void setPassengerFirstName(String passengerFirstName){this.passengerFirstName = passengerFirstName;}

    public void setPassengerSecondName(String passengerSecondName){this.passengerSecondName = passengerSecondName;}

    public void setUserId(int userId){this.userId = userId;}

    public void setTripId(int tripId){this.tripId = tripId;}

    public void setFromStation(int fromStation) {this.fromStation = fromStation;}

    public void setToStation(int toStation) {this.toStation = toStation;}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "tripId='" + tripId + '\'' +
                ", firstName='" + passengerFirstName + '\'' +
                ", lastName='" + passengerSecondName + '\'' +
                ", departureStation='" + departureTrainStationName + '\'' +
                ", arrivalStation='" + arrivalTrainStationName + '\'' +
                ", train='" + trainNumber + '\'' +
                ", vagon='" + vagonNumber + '\'' +
                ", seat='" + seatNumber + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                '}';
    }
}
