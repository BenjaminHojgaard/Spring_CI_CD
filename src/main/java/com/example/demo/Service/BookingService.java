package com.example.demo.Service;

import dto.BookingDTO;
import dto.CreateBookingDTO;
import org.springframework.stereotype.Service;
import service.BookingUtility;

@Service
public class BookingService implements BookingUtility {

    @Override
    public boolean createBooking(CreateBookingDTO createBookingDTO) {
        return false;
    }

    @Override
    public boolean cancelBooking(int i) {
        return false;
    }

    @Override
    public BookingDTO findBooking(int i) {
        return null;
    }
}
