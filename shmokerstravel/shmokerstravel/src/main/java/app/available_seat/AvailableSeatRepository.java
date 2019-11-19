package app.available_seat;

import app.available_seat.model.AvailableSeat;
import app.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AvailableSeatRepository extends JpaRepository<AvailableSeat, Integer> {

    @Query("select seat_number from available_seat")
    List<AvailableSeat> getAvailableSeatByDepartureDateAndArrivalDateAndFromStationAndToStation(
            @Param("departureDate") Date dDate, @Param("arrivalDate") Date aDate,
            @Param("fromStation") Date fStation, @Param("toStaion") Date tStation);

}
