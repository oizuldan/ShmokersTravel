package app.ticket.controller;

import app.route.AvailableSeatRepository;
import app.route.model.AvailableSeat;
import app.session.SessionRepository;
import app.ticket.TicketRepository;
import app.ticket.model.Ticket;
//import javafx.util.Pair;
import app.user.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    AvailableSeatRepository availableSeatRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    LogsRepository logsRepository;

    @CrossOrigin
    @PostMapping("/createTicket")
    public Ticket createTicket(@RequestBody Map<String, String> body) throws Error, ParseException, IOException {
        int price = Integer.parseInt(body.get("price"));
        String hash = body.get("hash");
        String departureTrainStationName = body.get("departureTrainStationName");
        String arrivalTrainStationName = body.get("arrivalTrainStationName");
        int seatNumber = Integer.parseInt(body.get("seatNumber"));
        int trainNumber = Integer.parseInt(body.get("trainNumber"));
        int vagonNumber = Integer.parseInt(body.get("vagonNumber"));
        int tripId = Integer.parseInt(body.get("tripId"));
        int fromStation = Integer.parseInt(body.get("fromStation"));
        int toStation = Integer.parseInt(body.get("toStation"));
        String passengerFirstName = body.get("passengerFirstName");
        String passengerSecondName = body.get("passengerSecondName");
        Date arrivalDate = new Date(Long.parseLong(body.get("arrivalDate")));
        Date departureDate = new Date(Long.parseLong(body.get("departureDate")));

        Ticket ticket = new Ticket();

        int userId = 0;
        try{
            userId = sessionRepository.getUserId(hash);
        } catch (Error error) {
            throw new Error("unauthorized user");
        }


        ticket.setUserId(userId);
        ticket.setArrivalDate(arrivalDate);
        ticket.setDepartureDate(departureDate);
        ticket.setArrivalTrainStationName(arrivalTrainStationName);
        ticket.setDepartureTrainStationName(departureTrainStationName);
        ticket.setPassengerFirstName(passengerFirstName);
        ticket.setPassengerSecondName(passengerSecondName);
        ticket.setPrice(price);
        ticket.setSeatNumber(seatNumber);
        ticket.setTrainNumber(trainNumber);
        ticket.setVagonNumber(vagonNumber);
        ticket.setTripId(tripId);
        ticket.setFromStation(fromStation);
        ticket.setToStation(toStation);

        List<Object[]> res = availableSeatRepository.getAvailableSeat(seatNumber, vagonNumber,
                trainNumber, tripId, fromStation, toStation);

        Iterator it = res.iterator();
        int availableFrom = 0, availableTo = 0, prevPrice = 0;


        while (it.hasNext()){
            Object[] line = (Object[]) it.next();
            availableFrom = (int) line[0];
            availableTo = (int)line[1];
            prevPrice = (int) line[2];
        }


        if(availableFrom != 0 && availableTo != 0 && prevPrice != 0) {
            availableSeatRepository.deleteSeat(seatNumber, vagonNumber, trainNumber, tripId, availableFrom, availableTo);

            if(availableFrom > fromStation) {
                AvailableSeat newSeat = new AvailableSeat(prevPrice, tripId, availableFrom, fromStation, seatNumber, vagonNumber, trainNumber, departureDate);

                availableSeatRepository.save(newSeat);
            }

            if(availableTo > toStation) {
                AvailableSeat newSeat = new AvailableSeat(prevPrice, tripId, toStation, availableTo, seatNumber, vagonNumber, trainNumber, departureDate);

                availableSeatRepository.save(newSeat);
            }
        } else {
            throw  new Error("the seat is unavailable");
        }

        if(logsRepository.findAll().get(0).getStatus()) {
            File file = new File("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt");
            FileWriter fr = new FileWriter(file, true);
            String output = "Ticket Created: userId -> " + userId + "; ticketId -> " + ticket.getId() + " ----- date -> " + new Date() + "\n";

            fr.write(output);
            fr.close();
        }

        return ticketRepository.save(ticket);
    }

    @CrossOrigin
    @DeleteMapping("/deleteTicket/{id}")
    public boolean deleteTicket(@PathVariable String id) throws Error, IOException {
        Ticket ticket = ticketRepository.findOne(Integer.parseInt(id));

        if(ticket == null) {
            throw new Error("no such ticket");
        }

        List<Object[]> res = availableSeatRepository.getIntervalsSeats(ticket.getDepartureTrainStationName(),
        ticket.getArrivalTrainStationName(), ticket.getTripId(), ticket.getDepartureDate(), ticket.getArrivalDate());
        ArrayList<Interval> intervals = new ArrayList<>();

        Iterator it = res.iterator();

        while (it.hasNext()){
            Object[] line = (Object[]) it.next();
            intervals.add(new Interval((int) line[0], (int) line[1]));
        }

        for(Interval i : intervals){
            availableSeatRepository.deleteSeat(ticket.getSeatNumber(), ticket.getVagonNumber(), ticket.getTrainNumber(), ticket.getTripId(), i.getStart(), i.getEnd());
        }

        intervals.add(new Interval(ticket.getFromStation(), ticket.getToStation()));

        intervals = merge(intervals);

        for(Interval i : intervals){
            availableSeatRepository.save(new AvailableSeat(ticket.getPrice(),
                    ticket.getTripId(),
                    i.getStart(), i.getEnd(),
                    ticket.getSeatNumber(),
                    ticket.getVagonNumber(),
                    ticket.getTrainNumber(),
                    ticket.getDepartureDate()));
        }

        ticketRepository.delete(Integer.parseInt(id));

        if(logsRepository.findAll().get(0).getStatus()) {
            File file = new File("/Users/icett/Desktop/NU/3year_1stSem/SWE/ShmokersTravel/shmokerstravel/shmokerstravel/logs.txt");
            FileWriter fr = new FileWriter(file, true);
            String output = "Ticket Deleted: userId -> " + ticket.getUserId() + "; ticketId -> " + ticket.getId() + " ----- date -> " + new Date() + "\n";

            fr.write(output);
            fr.close();
        }

        return true;
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if(intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());

        Interval first = intervals.get(0);
        int start = first.getStart();
        int end = first.getEnd();

        ArrayList<Interval> result = new ArrayList<Interval>();

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.getStart() <= end) {
                end = Math.max(current.getEnd(), end);
            } else {
                result.add(new Interval(start, end));
                start = current.getStart();
                end = current.getEnd();
            }
        }

        result.add(new Interval(start, end));
        return result;
    }
}


class Interval
{
    private int start;
    private int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e)
    {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval i1, Interval i2)
    {
        return i1.getStart() - i2.getStart();
    }
}