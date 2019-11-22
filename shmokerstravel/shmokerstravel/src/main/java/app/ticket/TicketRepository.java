package app.ticket;

import app.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("select t.id, t.userId, t.price, t.seatNumber, t.vagonNumber, t.trainNumber, t.tripId, t.arrivalTrainStationName,\n" +
            "t.arrivalDate, t.departureTrainStationName, t.departureDate, us.firstName, us.lastName\n" +
            "from Ticket t, User us where t.userId = :userId and us.id = :userId")
    List<Object> findByUserId(@Param("userId") int userId);

}
