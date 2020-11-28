package com.example.demo.unit;
import Service.HotelService;
import dto.HotelDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class HotelServiceTest {


    @Test


    public void getHotelsMustReturnAnArrayWhichIsNotEmpty() throws RemoteException {
        //Arrange
        ArrayList<HotelDTO> expectetHotels =  new ArrayList<>();
        expectetHotels.add(new HotelDTO("Radison", "Radison Street", "berlin"));
        expectetHotels.add(new HotelDTO("Hilton", "Hilton Street", "London"));

        //Act
        HotelService hs = new HotelService();
        ArrayList result = hs.getHotels();

        //Assert
        assertFalse(result.isEmpty());
    }
    public void getHotelsMust() throws RemoteException {
        //Arrange
        ArrayList<HotelDTO> expectetHotels =  new ArrayList<>();
        expectetHotels.add(new HotelDTO("Radison", "Radison Street", "berlin"));
        expectetHotels.add(new HotelDTO("Hilton", "Hilton Street", "London"));

        //Act


        HotelService hs = new HotelService();
        ArrayList result = hs.getHotels();


        //Assert
        assertFalse(result.isEmpty());
    }


}
