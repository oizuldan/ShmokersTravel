package app.route;

import app.route.model.AvailableRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import app.route.model.AvailableRoute;

@Repository
public interface AvailableRouteRepository extends JpaRepository<AvailableRoute, Integer> {

    @Query("select S1.train_station_name as from_station, S2.train_station_name as to_station, AR.route_id, count (AR.route_id) as available_seats, AR.ticket_price FROM Station S1 inner join Station S2 on S1.route_id = S2.route_id and S1.station_index < S2.station_index inner join AvailableRoute AR on S1.route_id = AR.route_id where S1.train_station_name = :from and S2.train_station_name = :to and AR.from_station >= S1.station_index and AR.to_station <= S2.station_index group by AR.route_id, AR.ticket_price")
    AvailableRoute findByFromStationAndToStation(@Param("from") String from, @Param("to") String to);


}
