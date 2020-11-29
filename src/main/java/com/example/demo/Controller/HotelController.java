package com.example.demo.Controller;

import com.example.demo.Service.BookingService;
import com.example.demo.Service.HotelService;
import dto.HotelDTO;
import dto.RoomDTO;
import org.apache.log4j.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

    final Logger logger = Logger.getLogger(HotelController.class);

    final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
        logger.info("Constructor called");
    }

    @GetMapping("/VacantHotels/{city}/{date}/{numberOfGuests}")
    public Collection<HotelDTO> findVacantRooms(@PathVariable String city, @PathVariable String date, @PathVariable int numberOfGuests) throws ParseException {
        logger.info("findVacantRooms called");
        Date date1 = new SimpleDateFormat("dd-MM-YYYY").parse(date);
        return hotelService.findVacantHotels(city, date1, numberOfGuests);
    }
}
