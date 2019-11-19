package app.ticket.controller;

import app.route.SeatRepository;
import app.ticket.TicketRepository;
import app.ticket.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @CrossOrigin
    @GetMapping("/getTickets")
    public Ticket getTicket(@RequestParam(name = "firstName") String fName, @RequestParam(name = "lastName") String lName,
                            @RequestParam(name = "arrivalDate") Date aDate, @RequestParam(name = "departureDate") Date dDate){
        return ticketRepository.getTicketByFirstNameAndLastName(fName, lName, aDate, dDate);
    }
}
