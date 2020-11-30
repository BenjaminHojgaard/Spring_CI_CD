package com.example.demo.Service;

import com.example.demo.Controller.HomeController;
import com.example.demo.URLs;
import dto.BookingDTO;
import dto.CreateBookingDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.BookingUtility;
import org.apache.log4j.Logger;

@Service
public class BookingService implements BookingUtility {

    private final static Logger logger = Logger.getLogger(HomeController.class);

    static RestTemplate restTemplate;

    public BookingService() {
        logger.info("Constructor called");
        restTemplate = new RestTemplate();
    }

    public BookingService(RestTemplate template) {
        restTemplate = template;
    }

    @Override
    public boolean createBooking(CreateBookingDTO createBookingDTO) {
        logger.info("createBooking - called");
        ResponseEntity<Boolean> response = restTemplate.postForEntity(URLs.BACKEND_URL + "booking", createBookingDTO, Boolean.class);
        logger.info("createBooking - response received with statuscode: " + response.getStatusCode());
        return response.getBody();
    }

    @Override
    public boolean cancelBooking(int bookingID) {
        logger.info("cancelBooking - called");
        restTemplate.delete(URLs.BACKEND_URL + "booking/{bookingID}", bookingID);
        var result = findBooking(bookingID);
        logger.info("cancelBooking - result: " + result);
        return result.getRoomBookings().isEmpty();
    }

    @Override
    public BookingDTO findBooking(int bookingID) {
        logger.info("findBooking - called");
        ResponseEntity<BookingDTO> response = restTemplate.getForEntity(URLs.BACKEND_URL + "booking/{bookingID}", BookingDTO.class, bookingID);
        logger.info("findBooking - response received with statuscode: " + response.getStatusCode());
        return response.getBody();
    }
}
