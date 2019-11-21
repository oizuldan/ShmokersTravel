package app.route;

import app.route.model.TripStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StationRepository extends  JpaRepository<TripStation, Integer> {
    @Query("SELECT tripId, stationIndex, arrivalDate,departureDate, trainStationName FROM TripStation")
    List<TripStation> find();

    @Query("SELECT T.departureTrainStationName, T.arrivalTrainStationName, " +
            "S.tripId, S.arrivalDate, S.departureDate\n" +
            "FROM TripStation S, Trip T where S.trainStationName = :name and " +
            "S.tripId = T.id")
    List<Object[]> findTripsOnStation(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("delete from TripStation where tripId = :tripId")
    void deleteTripStation( @Param("tripId") int tripId);
}