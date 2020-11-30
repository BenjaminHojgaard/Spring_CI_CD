package com.example.demo.Service;

import dto.BookingDTO;
import dto.CreateBookingDTO;
import dto.HotelDTO;
import dto.VacantHotelsDTO;
import org.springframework.stereotype.Service;
import service.HotelUtility;

import java.util.Collection;
import java.util.Date;

@Service
public class HotelService implements HotelUtility {


    @Override
    public Collection<HotelDTO> findVacantHotels(VacantHotelsDTO vacantHotelsDTO) {
        return null;
    }
}
