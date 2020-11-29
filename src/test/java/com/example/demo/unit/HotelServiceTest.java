package com.example.demo.unit;
import Service.HotelService;
import com.github.javafaker.Faker;
import dto.HotelDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {


    @Mock
    HotelDTO hotelDTOMock;

    private Faker faker = new Faker();


    @BeforeAll
    public void beforeAll(){
         hotelDTOMock = mock(HotelDTO.class);

    }


    @Test
    public void mustReturnListOfVacantHotels() throws RemoteException {
        //Arrange

        ArrayList<dto.HotelDTO> target = new ArrayList();
        target.add(hotelDTOMock);


//
       // Mockito.doReturn(target).when(hotelHandlerMock).fetchHotels(faker.address().city(), faker.date().birthday(), 4);


        //when(bankMock.getAccount("XYZ-456")).thenReturn(target);
        //source.transfer(2_000_00L, "XYZ-456");
        //assertEquals(-2_000_00L, source.getBalance());
       // assertEquals(target, hotelHandlerMock.fetchHotels(faker.address().city(), faker.date().birthday(), 4));

        //Act
        HotelService hs = new HotelService();
        hs.findVacantHotels()

        //Assert

    }






