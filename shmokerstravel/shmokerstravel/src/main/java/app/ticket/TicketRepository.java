package app.ticket;

import app.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("select all\n" +
            "from ticket T\n" +
            "where T.passengerFirstName = :fName and T.passengerLastName = :lName \n" +
            "and T.arrivalDate = :aDate\n" +
            "and T.departureDate = :dDate\n")
    Ticket getTicketByFirstNameAndLastName(@Param("firstName") String fName, @Param("lastName") String lName,
                                           @Param("arrivalDate") Date aDate, @Param("departureDate") Date dDate);

}
