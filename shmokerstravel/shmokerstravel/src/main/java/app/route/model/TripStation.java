package app.route.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trip_station")
@IdClass(TripStationKeys.class)
public class TripStation {

    @Id
    @Column(name = "trip_id")
    private int tripId;

    @Id
    @Column(name = "station_index")
    private int stationIndex;

    @Id
    @Column(name = "train_station_name")
    private String trainStationName;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "departure_date")
    private Date departureDate;


    public TripStation() {}

    public TripStation(
            int tripId,
            int stationIndex,
            String stationName,
            Date arrivalDate,
            Date departureDate
            ) {
        this.tripId = tripId;
        this.stationIndex = stationIndex;
        this.trainStationName = stationName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public int getTripId() { return tripId;}

    public int getStationIndex() { return stationIndex;}

    public String getStationName() { return trainStationName;}

    public Date getArrivalDate() { return arrivalDate;}

    public Date getDepartureDate() { return departureDate;}


    public void setTripId(int tripId){
        this.tripId = tripId;
    }

    public void setStationIndex(int stationIndex){
        this.stationIndex = stationIndex;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setTrainStationName(String trainStationName) {
        this.trainStationName = trainStationName;
    }


    @Override
    public String toString() {
        return "TripStation{" +
                "tripId='" + tripId + '\'' +
                "stationIndex='" + stationIndex + "\'" +
                "stationName='" + trainStationName + "\'" +
                "arrivalDate='" + arrivalDate + '\'' +
                "departureDate='" + departureDate + '\'' +
                '}';
    }
}