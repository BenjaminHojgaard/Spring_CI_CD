package com.example.demo.Controller;

import com.example.demo.Service.BookingService;
import dto.BookingDTO;
import dto.CreateBookingDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Booking")
public class BookingController {
    final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{createBookingDTO}")
    public boolean createBooking(@PathVariable CreateBookingDTO createBookingDTO) {
        return bookingService.createBooking(createBookingDTO);
    }
    @DeleteMapping("/{bookingID}")
    public boolean cancelBooking(@PathVariable int bookingID){
        return bookingService.cancelBooking(bookingID);
    }

    @GetMapping("/{bookingID}")
    public BookingDTO findBooking(@PathVariable int bookingID){
        return bookingService.findBooking(bookingID);
    }
}
