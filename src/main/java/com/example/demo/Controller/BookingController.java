package com.example.demo.Controller;

import com.example.demo.Service.BookingService;
import dto.BookingDTO;
import dto.CreateBookingDTO;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final static Logger logger = Logger.getLogger(BookingController.class);

    final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
        logger.info("Constructor called");
    }

    @PostMapping("")
    public boolean createBooking(@RequestBody CreateBookingDTO createBookingDTO) {
        logger.info("createBooking - called");
        return bookingService.createBooking(createBookingDTO);
    }
    @DeleteMapping("/{bookingID}")
    public boolean cancelBooking(@PathVariable int bookingID){
        logger.info("cancelBooking - called");
        return bookingService.cancelBooking(bookingID);
    }

    @GetMapping("/{bookingID}")
    public BookingDTO findBooking(@PathVariable int bookingID){
        logger.info("findBooking - called");
        return bookingService.findBooking(bookingID);
    }
}
