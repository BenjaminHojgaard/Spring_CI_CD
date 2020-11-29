package com.example.demo.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RoomServiceTest {

    ArrayList<String> roomNumbers;

    @BeforeEach
    void setup(){
        roomNumbers = new ArrayList<>();
    }


    @Test
    public void mustReturnErrorWhenAnAlreadyTakenRoomNumberIsGiven() {
        //Arrange
        RoomService rs = new RoomService();
        roomNumbers.add("a11");


        //Act
        boolean result = rs.markRoomAsReserved(roomNumbers);


        //Assert
        assertFalse(result);

    }

    @Test
    public void mustReturnTrueWhenRoomIsMarkedAsReserved() {
        //Arrange
        RoomService rs = new RoomService();
        roomNumbers.add("a12");

        //Act
        boolean result = rs.markRoomAsReserved(roomNumbers);

        //Assert
        assertTrue(result);
    }
}
