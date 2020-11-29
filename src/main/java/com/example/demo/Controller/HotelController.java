package com.example.demo.Controller;

import com.example.demo.Service.BookingService;
import com.example.demo.Service.HotelService;
import dto.CreateBookingDTO;
import org.apache.log4j.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class HotelController {

    final Logger logger = Logger.getLogger(HotelController.class);

    final BookingService bookingService;

    public HotelController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping("/hotel")
    public boolean hotel() {
        logger.info("hotel entered");
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        return bookingService.createBooking(
                new CreateBookingDTO(list, "", 1,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
                true)
        );
    }
}
