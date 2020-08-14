package com.d9nich.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AirportController {
    private final List<AirportInfo> airportInfoList = new ArrayList<>();

    public AirportController() {
        airportInfoList.add(new AirportInfo("Kilimanjaro Arusha", "ARK", "HTAR"));
        airportInfoList.add(new AirportInfo("Berlin Schönefeld", "TXL", "EDDT"));
        airportInfoList.add(new AirportInfo("Delhi Indira Gandhi", "DEL", "VIDP"));
        airportInfoList.add(new AirportInfo("Tokio Haneda", "HND", "RJTT"));
    }

    private static final String SERVICE_WARNING_MESSAGE = "Berlin Schönefeld is closed for service today";

    @GetMapping("airports/{id}")
    public AirportInfo getAirportInfo(@PathVariable int id) {
        final AirportInfo airportInfo = airportInfoList.get(id);
        if (airportInfo.getFrom().equals("Berlin Schönefeld"))
            throw new FlightNotFoundException(SERVICE_WARNING_MESSAGE);
        return airportInfo;
    }
}

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
}
