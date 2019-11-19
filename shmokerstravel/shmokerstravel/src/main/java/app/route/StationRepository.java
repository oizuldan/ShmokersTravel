package app.route;

import app.route.model.AvailableRoute;
import app.route.model.Route;
import app.route.model.RouteStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends  JpaRepository<RouteStation, Integer> {
    @Query("SELECT routeId, stationIndex, arrivalDate,departureDate, trainStationName FROM RouteStation")
    List<RouteStation> find();
}