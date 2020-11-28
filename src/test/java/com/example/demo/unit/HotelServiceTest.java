package com.example.demo.unit;
import Service.HotelService;
import com.github.javafaker.Faker;
import dto.HotelDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.HotelUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HotelServiceTest {


    // DOC (Depended-on Component)
    private HotelService hotelServiceMock;
    private Faker faker = new Faker();


    @BeforeAll
    public void beforeAll(){
         hotelServiceMock = mock(HotelService.class);



    }

    @Test
    public void getHotelsMustReturnAnArrayWhichIsNotEmpty() throws RemoteException {
        //Arrange
        ArrayList<HotelDTO> expectetHotels =  new ArrayList<>();
        expectetHotels.add(new HotelDTO("Radison", "Radison Street", "berlin"));
        expectetHotels.add(new HotelDTO("Hilton", "Hilton Street", "London"));

        //Act
        //HotelService hs = new HotelService();

        ArrayList result = hotelServiceMock.findVacantHotels(faker.address().city(), faker.date().birthday(), 5);
        System.out.println(result);
        //Assert
        assertFalse(result.isEmpty());
    }
    public void findVacantHotelsMustNotBeEmpty() throws RemoteException {
        //Arrange

        //Act
        HotelService hs = new HotelService();
        ArrayList result = hs.findVacantHotels("london", new Date(2020, 12,12), 5);

        //Assert
        assertFalse(result.isEmpty());
    }

    public void findVacantHotelMustDisplayAHotelUnavailableErrorMessageWhenNoHotelsAreAvailable(){
        //HotelService hs = new HotelService();
        //ArrayList result = hs.findVacantHotels("london", new Date(2020, 12,12), 5);


    }





}
