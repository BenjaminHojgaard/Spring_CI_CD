package com.example.demo.Service;

import dto.BookingDTO;
import dto.CreateBookingDTO;
import dto.HotelDTO;
import org.springframework.stereotype.Service;
import service.HotelUtility;

import java.util.Collection;
import java.util.Date;

@Service
public class HotelService implements HotelUtility {

    @Override
    public Collection<HotelDTO> findVacantHotels(String s, Date date, int i) {
        return null;
    }

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
