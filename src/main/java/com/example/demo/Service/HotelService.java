package com.example.demo.Service;

import dto.BookingDTO;
import dto.CreateBookingDTO;
import dto.HotelDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.HotelUtility;

import java.util.Collection;
import java.util.Date;

@Service
public class HotelService implements HotelUtility {

    static RestTemplate restTemplate = new RestTemplate();
    static final String URL = "http://localhost:8080/ISBN/";

    @Override
    public Collection<HotelDTO> findVacantHotels(String s, Date date, int i) {

        VacantHotelsDTO dto = new VacantHotelsDTO();

        ResponseEntity<Collection<HotelDTO>> entity = restTemplate.getForEntity(URL, dto, Collection.class);


        return entity.getBody();
    }
}
