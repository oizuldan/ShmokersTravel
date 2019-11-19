package app.route.controller;

import app.route.AvailableRouteRepository;
import app.route.RouteRepository;
import app.route.SeatRepository;
import app.route.StationRepository;
import app.route.model.AvailableRoute;
import app.route.model.Route;
import app.route.model.Seat;
import app.route.model.RouteStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RouteController {

    @Autowired
    SeatRepository seatRepository;
    @Autowired
    AvailableRouteRepository availableRouteRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    RouteRepository routeRepository;

    @CrossOrigin
    @GetMapping("/availableRoute")
    public List<AvailableRoute> getAvailableRoutes(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to) {
        return availableRouteRepository.findByFromStationAndToStation(from, to);
    }

    @CrossOrigin
    @GetMapping("/getSeats")
    public List<AvailableRoute> getSeats(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to, @RequestParam(name = "routeId") int routeId) {
        return availableRouteRepository.getAvailableSeats(from, to, routeId);
    }

    @CrossOrigin
    @GetMapping("/route")
    public List<Route> getRoute(@RequestParam(name = "departure") String departureTrainStationName, @RequestParam(name = "arrival") String arrivalTrainStationName) {
        List<Route> routes = routeRepository.findAll()
                .stream()
                .filter(s -> s.getDepartureTrainStationName().equals(departureTrainStationName) && s.getArrivalTrainStationName().equals(arrivalTrainStationName))
                .collect(Collectors.toList());

        return routes;
    }
}
