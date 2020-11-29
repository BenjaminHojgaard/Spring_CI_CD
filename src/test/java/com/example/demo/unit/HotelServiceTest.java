package com.example.demo.unit;


import com.example.demo.Service.HotelService;
import dto.BookingDTO;
import dto.RoomBookingDTO;
import dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {

    @Mock RoomBookingDTO roomBookingMock;
    @Mock RoomDTO roomMock;


  /*  @Test
    public void mustReturnTrueWhenABookingIsMade() {
        //Arrange
        ArrayList<RoomBookingDTO> roomBookings =  new ArrayList<>();
        roomBookings.add(roomBookingMock);

        BookingDTO booking = new BookingDTO("passportnumber", roomBookings, false, 3 {

        //Act

        HotelService hotelService = new HotelService();


            var result = ;
        
        //Assert
        assertEquals(expected, result);
    
    }*/
}
