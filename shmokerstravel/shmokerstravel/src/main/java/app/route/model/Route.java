package app.route.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "route_id")
    private int id;

    @Column(name = "departure_train_station_name")
    private String departureTrainStationName;

    @Column(name = "arrival_train_station_name")
    private String arrivalTrainStationName;

    @Column(name = "departure_date")
    private Date departureDateTime;

    @Column(name = "arrival_date")
    private Date arrivalDateTime;

    public  Route() {}

    public Route(String departureTrainStationName,
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

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                "departureTrainStationName='" + departureTrainStationName + "\'" +
                "arrivalTrainStationName='" + arrivalTrainStationName + "\'" +
                "departureDateTime='" + departureDateTime + '\'' +
                "arrivalDateTime='" + arrivalDateTime + '\'' +
                '}';
    }
}
