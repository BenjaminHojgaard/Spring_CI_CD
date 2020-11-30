package com.example.demo.Service;

import com.example.demo.Controller.HomeController;
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

    String URL = "";
    RestTemplate template = new RestTemplate();

    public BookingService() {
        logger.info("Constructor called");
    }

    @Override
    public boolean createBooking(CreateBookingDTO createBookingDTO) {
        logger.info("createBooking - called");
        ResponseEntity<Boolean> response = template.getForEntity(URL, Boolean.class, createBookingDTO);
        logger.info("createBooking - response received with statuscode: " + response.getStatusCode());
        return response.getBody();
    }

    @Override
    public boolean cancelBooking(int bookingID) {
        logger.info("cancelBooking - called");
        template.delete(URL, Boolean.class, bookingID);
        var result = findBooking(bookingID);
        logger.info("cancelBooking - result: " + result);
        return result == null;
    }

    @Override
    public BookingDTO findBooking(int bookingID) {
        logger.info("findBooking - called");
        ResponseEntity<BookingDTO> response = template.getForEntity(URL, BookingDTO.class, bookingID);
        logger.info("findBooking - response received with statuscode: " + response.getStatusCode());
        return response.getBody();
    }
}
