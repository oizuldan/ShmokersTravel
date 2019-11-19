package app.route;

import app.route.model.AvailableRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableRouteRepository extends JpaRepository<AvailableRoute, Integer> {

    @Query("select AR.routeId, count(AR.routeId) as available_seats, AR.ticketPrice\n" +
            "from RouteStation S1, RouteStation S2, AvailableRoute AR\n" +
            "where S1.routeId = S2.routeId and S1.stationIndex < S2.stationIndex \n" +
            "and S1.routeId = AR.routeId\n" +
            "and S1.trainStationName = :from and S2.trainStationName = :to \n" +
            "and AR.fromStation >= S1.stationIndex and AR.toStation <= S2.stationIndex\n" +
            "group by AR.routeId, AR.ticketPrice")
    List<AvailableRoute> findByFromStationAndToStation(@Param("from") String from, @Param("to") String to);

    @Query("select AR.vagonNumber, AR.seatNumber\n" +
            "from RouteStation S1, RouteStation S2, AvailableRoute AR\n" +
            "where S1.routeId = :id and S1.stationIndex < S2.stationIndex \n" +
            "and AR.routeId = :id\n" +
            "and S2.routeId = :id\n" +
            "and S1.trainStationName = :from and S2.trainStationName = :to \n" +
            "and AR.fromStation >= S1.stationIndex and AR.toStation <= S2.stationIndex\n")
    List<AvailableRoute> getAvailableSeats(@Param("from") String from, @Param("to") String to, @Param("id") int id);


}
