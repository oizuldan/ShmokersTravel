package app.route.controller;

import app.route.AvailableSeatRepository;
import app.route.TripRepository;
import app.route.SeatRepository;
import app.route.StationRepository;
import app.route.model.AvailableSeat;
import app.route.model.Trip;
import app.route.model.TripStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TripController {

    @Autowired
    SeatRepository seatRepository;
    @Autowired
    AvailableSeatRepository availableSeatRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    StationRepository tripStationRepository;

    @CrossOrigin
    @GetMapping("/availableTrip")
    public List<Object[]> getAvailableSeats(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to, @RequestParam(name = "date") String date, @RequestParam(name = "dateLimit") String dateLimit) throws ParseException {
        Date departure = new Date( Long.parseLong(date));
        Date arrival = new Date( Long.parseLong(dateLimit));

        return availableSeatRepository.findByFromStationAndToStation(from, to, departure, arrival);

    }

    @CrossOrigin
    @GetMapping("/getSeats")
    public List<Object[]> getSeats(@RequestParam(name = "from") String from,
                                        @RequestParam(name = "to") String to,
                                        @RequestParam(name = "tripId") int tripId,
                                        @RequestParam(name = "date") String date,
                                        @RequestParam(name = "dateLimit") String dateLimit) {
        return availableSeatRepository.getAvailableSeats(from, to, tripId,
                new Date(Long.parseLong(date)),
                new Date(Long.parseLong(dateLimit)));
    }

//    @CrossOrigin
//    @GetMapping("/getSeat")
//    public void getSeat(@RequestParam(name = "tripId") int tripId,
//                                 @RequestParam(name = "fromStation") int fromStation,
//                                 @RequestParam(name = "toStation") int toStation,
//                                 @RequestParam(name = "seatNumber") int seatNumber,
//                                 @RequestParam(name = "trainNumber") int trainNumber,
//                                 @RequestParam(name = "vagonNumber") int vagonNumber) {
//
//
//        List<Object[]> res = availableSeatRepository.getAvailableSeat(seatNumber, vagonNumber,
//                trainNumber, tripId, fromStation, toStation);
//
//        Iterator it = res.iterator();
//
//
//        while (it.hasNext()){
//            Object[] line = (Object[]) it.next();
//            System.out.println(line[0]);
//            System.out.println(line[1]);
//        }
//    }

    @CrossOrigin
    @PostMapping("/createTrip")
    public Trip login(@RequestBody Map<String, String> body){
        Trip trip = new Trip();
        String departureTrainStationName = body.get("departureTrainStationName");
        String arrivalTrainStationName = body.get("arrivalTrainStationName");
        long dateTime = Long.parseLong(body.get("dateTime"));
        long arrivalDateTime = 0;
        long departureDateTime = 0;


        if(departureTrainStationName.equals("Nur-Sultan") && arrivalTrainStationName.equals("Petropavl")) {
            departureDateTime = dateTime + 28800000;
            arrivalDateTime = dateTime + 57600000;
        }else if(departureTrainStationName.equals("Petropavl") && arrivalTrainStationName.equals("Nur-Sultan")){
            departureDateTime = dateTime + 61200000;
            arrivalDateTime = dateTime + 90000000;
        }else if(departureTrainStationName.equals("Kokshetau") && arrivalTrainStationName.equals("Kostanay")){
            departureDateTime = dateTime + 43200000;
            arrivalDateTime = dateTime + 54000000;
        }else if(departureTrainStationName.equals("Kostanay") && arrivalTrainStationName.equals("Kokshetau")){
            departureDateTime = dateTime + 57600000;
            arrivalDateTime = dateTime + 68400000;
        }else if(departureTrainStationName.equals("Nur-Sultan") && arrivalTrainStationName.equals("Pavlodar")){
            departureDateTime = dateTime + 43200000;
            arrivalDateTime = dateTime + 54000000;
        }else if(departureTrainStationName.equals("Pavlodar") && arrivalTrainStationName.equals("Nur-Sultan")){
            departureDateTime = dateTime + 57600000;
            arrivalDateTime = dateTime + 68400000;
        }

        trip.setArrivalDateTime(new Date(arrivalDateTime));
        trip.setDepartureDateTime(new Date(departureDateTime));
        trip.setArrivalTrainStationName(arrivalTrainStationName);
        trip.setDepartureTrainStationName(departureTrainStationName);

        Trip newTrip = tripRepository.save(trip);

        if(departureTrainStationName.equals("Nur-Sultan") && arrivalTrainStationName.equals("Petropavl")) {
            TripStation newTripStation = new TripStation();

            newTripStation.setArrivalDate(null);
            newTripStation.setDepartureDate(new Date(dateTime + 28800000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(1);
            newTripStation.setTrainStationName("Nur-Sultan");

            System.out.println(newTripStation);

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 39600000));
            newTripStation.setDepartureDate(new Date(dateTime + 39600000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(2);
            newTripStation.setTrainStationName("Kokshetau");


            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 57600000));
            newTripStation.setDepartureDate(null);
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(3);
            newTripStation.setTrainStationName("Petropavl");

            stationRepository.save(newTripStation);

            for(int i = 1; i <= 5; i++) {
                AvailableSeat newSeat = new AvailableSeat();

                newSeat.setFromStation(1);
                newSeat.setToStation(3);
                newSeat.setDate(new Date(dateTime + 28800000));
                newSeat.setTicketPrice(500);
                newSeat.setTrainNumber(1);
                newSeat.setVagonNumber(1);
                newSeat.setSeatNumber(i);
                newSeat.setTripId(newTrip.getId());

                availableSeatRepository.save(newSeat);
            }
        }

        if(departureTrainStationName.equals("Petropavl") && arrivalTrainStationName.equals("Nur-Sultan")) {
            TripStation newTripStation = new TripStation();

            newTripStation.setArrivalDate(null);
            newTripStation.setDepartureDate(new Date(dateTime + 61200000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(1);
            newTripStation.setTrainStationName("Petropavl");

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 79200000));
            newTripStation.setDepartureDate(new Date(dateTime + 79200000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(2);
            newTripStation.setTrainStationName("Kokshetau");

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 90000000));
            newTripStation.setDepartureDate(null);
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(3);
            newTripStation.setTrainStationName("Nur-Sultan");

            stationRepository.save(newTripStation);

            for(int i = 1; i <= 5; i++) {
                AvailableSeat newSeat = new AvailableSeat();

                newSeat.setFromStation(1);
                newSeat.setToStation(3);
                newSeat.setDate(new Date(dateTime + 61200000));
                newSeat.setTicketPrice(500);
                newSeat.setTrainNumber(2);
                newSeat.setVagonNumber(1);
                newSeat.setSeatNumber(i);
                newSeat.setTripId(newTrip.getId());

                availableSeatRepository.save(newSeat);
            }
        }

        if(departureTrainStationName.equals("Kokshetau") && arrivalTrainStationName.equals("Kostanay")) {
            TripStation newTripStation = new TripStation();

            newTripStation.setArrivalDate(null);
            newTripStation.setDepartureDate(new Date(dateTime + 43200000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(1);
            newTripStation.setTrainStationName("Kokshetau");

            System.out.println(newTripStation);

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 54000000));
            newTripStation.setDepartureDate(null);
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(2);
            newTripStation.setTrainStationName("Kostanay");

            System.out.println(newTripStation);
            stationRepository.save(newTripStation);

            for(int i = 1; i <= 5; i++) {
                AvailableSeat newSeat = new AvailableSeat();

                newSeat.setFromStation(1);
                newSeat.setToStation(2);
                newSeat.setDate(new Date(dateTime + 43200000));
                newSeat.setTicketPrice(500);
                newSeat.setTrainNumber(3);
                newSeat.setVagonNumber(1);
                newSeat.setSeatNumber(i);
                newSeat.setTripId(newTrip.getId());

                availableSeatRepository.save(newSeat);

            }
        }

        if(departureTrainStationName.equals("Nur-Sultan") && arrivalTrainStationName.equals("Pavlodar")) {
            TripStation newTripStation = new TripStation();

            newTripStation.setArrivalDate(null);
            newTripStation.setDepartureDate(new Date(dateTime + 43200000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(1);
            newTripStation.setTrainStationName("Nur-Sultan");

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 54000000));
            newTripStation.setDepartureDate(null);
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(2);
            newTripStation.setTrainStationName("Pavlodar");

            stationRepository.save(newTripStation);

            for(int i = 1; i <= 5; i++) {
                AvailableSeat newSeat = new AvailableSeat();

                newSeat.setFromStation(1);
                newSeat.setToStation(2);
                newSeat.setDate(new Date(dateTime + 43200000));
                newSeat.setTicketPrice(500);
                newSeat.setTrainNumber(4);
                newSeat.setVagonNumber(1);
                newSeat.setSeatNumber(i);
                newSeat.setTripId(newTrip.getId());

                availableSeatRepository.save(newSeat);

            }
        }

        if(departureTrainStationName.equals("Kostanay") && arrivalTrainStationName.equals("Kokshetau")) {
            TripStation newTripStation = new TripStation();

            newTripStation.setArrivalDate(null);
            newTripStation.setDepartureDate(new Date(dateTime + 57600000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(1);
            newTripStation.setTrainStationName("Kostanay");

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 68400000));
            newTripStation.setDepartureDate(null);
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(2);
            newTripStation.setTrainStationName("Kokshetau");

            stationRepository.save(newTripStation);

            for(int i = 1; i <= 5; i++) {
                AvailableSeat newSeat = new AvailableSeat();

                newSeat.setFromStation(1);
                newSeat.setToStation(2);
                newSeat.setDate(new Date(dateTime + 57600000));
                newSeat.setTicketPrice(500);
                newSeat.setTrainNumber(5);
                newSeat.setVagonNumber(1);
                newSeat.setSeatNumber(i);
                newSeat.setTripId(newTrip.getId());

                availableSeatRepository.save(newSeat);

            }
        }

        if(departureTrainStationName.equals("Pavlodar") && arrivalTrainStationName.equals("Nur-Sultan")) {
            TripStation newTripStation = new TripStation();

            newTripStation.setArrivalDate(null);
            newTripStation.setDepartureDate(new Date(dateTime + 57600000));
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(1);
            newTripStation.setTrainStationName("Pavlodar");

            stationRepository.save(newTripStation);

            newTripStation.setArrivalDate(new Date(dateTime + 68400000));
            newTripStation.setDepartureDate(null);
            newTripStation.setTripId(newTrip.getId());
            newTripStation.setStationIndex(2);
            newTripStation.setTrainStationName("Nur-Sultan");

            stationRepository.save(newTripStation);

            for(int i = 1; i <= 5; i++) {
                AvailableSeat newSeat = new AvailableSeat();

                newSeat.setFromStation(1);
                newSeat.setToStation(2);
                newSeat.setDate(new Date(dateTime + 57600000));
                newSeat.setTicketPrice(500);
                newSeat.setTrainNumber(6);
                newSeat.setVagonNumber(1);
                newSeat.setSeatNumber(i);
                newSeat.setTripId(newTrip.getId());

                availableSeatRepository.save(newSeat);

            }
        }

        return newTrip;
    }

    @CrossOrigin
    @DeleteMapping("deleteTrip/{tripId}")
    public boolean delete(@PathVariable int tripId){
        availableSeatRepository.deleteSeats(tripId);
        tripStationRepository.deleteTripStation(tripId);
        tripRepository.delete(tripId);

        return true;
    }

    @CrossOrigin
    @GetMapping("/trips")
    public List<Trip> getTrips(@RequestParam(name = "departure") String departureTrainStationName, @RequestParam(name = "arrival") String arrivalTrainStationName) {
        List<Trip> trips = tripRepository.findAll()
                .stream()
                .filter(s -> s.getDepartureTrainStationName().equals(departureTrainStationName) && s.getArrivalTrainStationName().equals(arrivalTrainStationName))
                .collect(Collectors.toList());

        return trips;
    }

    @CrossOrigin
    @GetMapping("/allTrips")
    public List<Trip> getAllTrips() {

        return tripRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/na")
    public List<Object[]> getTripsOnStation(@RequestParam(name = "name") String name) {

        return tripStationRepository.findTripsOnStation(name);

    }
}
