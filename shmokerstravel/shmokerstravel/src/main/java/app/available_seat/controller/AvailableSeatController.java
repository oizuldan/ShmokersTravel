package app.available_seat.controller;

import app.available_seat.AvailableSeatRepository;
import app.available_seat.model.AvailableSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class AvailableSeatController {

    @Autowired
    AvailableSeatRepository availableSeatRepository;

    @CrossOrigin
    @GetMapping("/getAvailableSeat")
    public List<AvailableSeat> getAvailableSeat(@RequestParam("departureDate") Date dDate, @RequestParam("arrivalDate") Date aDate,
                                          @RequestParam("fromStation") Date fStation, @RequestParam("toStaion") Date tStation){
        return availableSeatRepository.getAvailableSeatByDepartureDateAndArrivalDateAndFromStationAndToStation(dDate, aDate, fStation, tStation);
    }
}
