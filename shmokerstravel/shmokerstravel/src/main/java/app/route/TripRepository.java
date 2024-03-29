package app.route;

import app.route.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TripRepository extends  JpaRepository<Trip, Integer>{

//    List<Trip> findByStations(String departureTrainStationName, String arrivalTrainStationName);

}
