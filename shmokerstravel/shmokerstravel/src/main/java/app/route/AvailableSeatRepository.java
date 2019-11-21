package app.route;

import app.route.model.AvailableSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface AvailableSeatRepository extends JpaRepository<AvailableSeat, Integer> {

    @Query("select AR.tripId, count(AR.tripId) as available_seats, AR.ticketPrice\n" +
            "from TripStation S1, TripStation S2, AvailableSeat AR\n" +
            "where S1.tripId = S2.tripId and S1.stationIndex < S2.stationIndex \n" +
            "and S1.tripId = AR.tripId\n" +
            "and S1.trainStationName = :from and S2.trainStationName = :to \n" +
            "and AR.fromStation >= S1.stationIndex and AR.toStation <= S2.stationIndex\n" +
            "and AR.date >= :date and AR.date <= :dateLimit\n" +
            "group by AR.tripId, AR.ticketPrice")
    List<Object[]> findByFromStationAndToStation(@Param("from") String from, @Param("to") String to, @Param("date") Date date, @Param("dateLimit") Date dateLimit);

    @Query("select AR.trainNumber, AR.vagonNumber, AR.seatNumber, S1.departureDate, S2.arrivalDate\n" +
            "from TripStation S1, TripStation S2, AvailableSeat AR\n" +
            "where S1.tripId = :id and S1.stationIndex < S2.stationIndex \n" +
            "and AR.tripId = :id\n" +
            "and S2.tripId = :id\n" +
            "and S1.trainStationName = :from and S2.trainStationName = :to \n" +
            "and AR.date >= :date and AR.date <= :dateLimit\n" +
            "and AR.fromStation >= S1.stationIndex and AR.toStation <= S2.stationIndex\n")
    List<Object[]> getAvailableSeats(@Param("from") String from, @Param("to") String to, @Param("id") int id, @Param("date") Date date, @Param("dateLimit") Date dateLimit);

    @Query("select AR.fromStation, AR.toStation\n" +
            "from TripStation S1, TripStation S2, AvailableSeat AR\n" +
            "where S1.tripId = :id and S1.stationIndex < S2.stationIndex \n" +
            "and AR.tripId = :id\n" +
            "and S2.tripId = :id\n" +
            "and S1.trainStationName = :from and S2.trainStationName = :to \n" +
            "and AR.date >= :date and AR.date <= :dateLimit\n" +
            "and AR.fromStation >= S1.stationIndex and AR.toStation <= S2.stationIndex\n")
    List<Object[]> getIntervalsSeats(@Param("from") String from, @Param("to") String to, @Param("id") int id, @Param("date") Date date, @Param("dateLimit") Date dateLimit);


    @Transactional
    @Modifying
    @Query("delete from AvailableSeat where seatNumber = :seatNumber and vagonNumber = :vagonNumber \n" +
            "and trainNumber = :trainNumber and tripId = :tripId and fromStation = :fromStation and \n " +
            "toStation = :toStation")
    void deleteSeat(@Param("seatNumber") int seatNumber, @Param("vagonNumber") int vagonNumber,
                    @Param("trainNumber") int trainNumber, @Param("tripId") int tripId,
                    @Param("fromStation") int fromStation, @Param("toStation") int toStation);

    @Transactional
    @Modifying
    @Query("delete from AvailableSeat where tripId = :tripId")
    void deleteSeats(@Param("tripId") int tripId);

    @Query("Select fromStation, toStation, ticketPrice from AvailableSeat where seatNumber = :seatNumber and vagonNumber = :vagonNumber \n" +
            "and trainNumber = :trainNumber and tripId = :tripId and fromStation <= :fromStation and \n " +
            "toStation >= :toStation")
    List<Object[]> getAvailableSeat(@Param("seatNumber") int seatNumber, @Param("vagonNumber") int vagonNumber,
                            @Param("trainNumber") int trainNumber, @Param("tripId") int tripId,
                            @Param("fromStation") int fromStation, @Param("toStation") int toStation);
}
