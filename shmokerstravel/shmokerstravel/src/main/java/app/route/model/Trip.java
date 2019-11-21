package app.route.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "trip_id")
    private int id;

    @Column(name = "departure_train_station_name")
    private String departureTrainStationName;

    @Column(name = "arrival_train_station_name")
    private String arrivalTrainStationName;

    @Column(name = "departure_date")
    private Date departureDateTime;

    @Column(name = "arrival_date")
    private Date arrivalDateTime;


    public Trip(){}

    public Trip(String departureTrainStationName,
                 String arrivalTrainStationName,
                 Date departureDateTime,
                 Date arrivalDateTime) {
        this.departureTrainStationName = departureTrainStationName;
        this.arrivalTrainStationName = arrivalTrainStationName;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public int getId() { return id;}

    public String getDepartureTrainStationName() { return departureTrainStationName;}

    public String getArrivalTrainStationName() { return arrivalTrainStationName;}

    public Date getDepartureDateTime() { return departureDateTime;}

    public Date getArrivalDateTime() { return arrivalDateTime;}


    public void setDepartureTrainStationName(String departureTrainStationName){
        this.departureTrainStationName = departureTrainStationName;
    }

    public void setArrivalTrainStationName(String arrivalTrainStationName){
        this.arrivalTrainStationName = arrivalTrainStationName;
    }

    public void setDepartureDateTime(Date departureDateTime){
        this.departureDateTime = departureDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime){
        this.arrivalDateTime = arrivalDateTime;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                "departureTrainStationName='" + departureTrainStationName + "\'" +
                "arrivalTrainStationName='" + arrivalTrainStationName + "\'" +
                "departureDateTime='" + departureDateTime + '\'' +
                "arrivalDateTime='" + arrivalDateTime + '\'' +
                '}';
    }
}
