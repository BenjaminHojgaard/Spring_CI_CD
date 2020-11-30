package com.example.demo.Service;

import com.example.demo.URLs;
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

    static RestTemplate restTemplate ;

    public HotelService() {
        restTemplate = new RestTemplate();
    }

    public HotelService(RestTemplate template) {
        restTemplate = template;
    }



    @Override
    public Collection<HotelDTO> findVacantHotels(VacantHotelsDTO vacantHotelsDTO) {
        ResponseEntity<Collection> entity = restTemplate.getForEntity(URLs.BACKEND_URL + "hotel", Collection.class, vacantHotelsDTO);
        return entity.getBody();
    }


}
