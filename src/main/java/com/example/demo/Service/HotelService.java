package com.example.demo.Service;

import dto.BookingDTO;
import dto.CreateBookingDTO;
import dto.HotelDTO;
import dto.VacantHotelsDTO;
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
    public Collection<HotelDTO> findVacantHotels(VacantHotelsDTO vacantHotelsDTO) {

        ResponseEntity<Collection> entity = restTemplate.getForEntity(URL, Collection.class, vacantHotelsDTO);


        return entity.getBody();
    }


}
