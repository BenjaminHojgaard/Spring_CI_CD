package com.example.demo.Controller;

import com.example.demo.Service.BookingService;
import com.example.demo.Service.HotelService;
import dto.BookingDTO;
import dto.HotelDTO;
import dto.RoomDTO;
import dto.VacantHotelsDTO;
import org.apache.log4j.Logger;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    final Logger logger = Logger.getLogger(HotelController.class);

    final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
        logger.info("Constructor called");
    }

    @GetMapping("/{city}/{date}/{numberOfGuests}")
    public Collection<HotelDTO> findVacantHotels(@PathVariable String city, @PathVariable Date date, @PathVariable int numberOfGuests) {
        logger.info("findVacantRooms called");
        var vacantHotelsDTO = new VacantHotelsDTO(city, date, numberOfGuests);
        return hotelService.findVacantHotels(vacantHotelsDTO);
    }
}
