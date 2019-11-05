package app.route;

import app.route.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RouteRepository extends  JpaRepository<Route, Integer>{

//    List<Route> findByStations(String departureTrainStationName, String arrivalTrainStationName);
}
