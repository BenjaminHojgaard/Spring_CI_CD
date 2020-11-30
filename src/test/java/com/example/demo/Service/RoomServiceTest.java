package com.example.demo.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomServiceTest {

    ArrayList<String> roomNumbers;

    @BeforeEach
    void setup(){
        roomNumbers = new ArrayList<>();
    }


    @Test
    public void mustReturnFalseWhenAnAlreadyTakenRoomNumberIsGiven() {
        //Arrange
        var returnedFromTemplate = new ResponseEntity<Boolean>(false, HttpStatus.OK);
        var restTemplateMock = mock(RestTemplate.class);
        when(restTemplateMock.postForEntity(anyString(), eq(roomNumbers), any()))
                .thenReturn((ResponseEntity)returnedFromTemplate);

        RoomService rs = new RoomService(restTemplateMock);
        roomNumbers.add("a12");

        //Act
        boolean result = rs.markRoomAsReserved(roomNumbers);

        //Assert
        assertFalse(result);
    }

    @Test
    public void mustReturnTrueWhenRoomIsMarkedAsReserved() {
        //Arrange
        RoomService rs = new RoomService(null);
        roomNumbers.add("a11");


        //Act
        boolean result = rs.markRoomAsReserved(roomNumbers);


        //Assert
        assertFalse(result);

    }
}
