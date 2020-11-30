package com.example.demo.Service;

import dto.RoomDTO;
import dto.VacantRoomsDTO;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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


    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    public void mustReturnTheRightValueInBodyWhenCalled(boolean value) {
        //Arrange
        var returnedFromTemplate = new ResponseEntity<Boolean>(value, HttpStatus.OK);
        var restTemplateMock = mock(RestTemplate.class);
        when(restTemplateMock.postForEntity(anyString(), eq(roomNumbers), any()))
                .thenReturn((ResponseEntity)returnedFromTemplate);

        RoomService rs = new RoomService(restTemplateMock);
        roomNumbers.add("a12");

        //Act
        boolean result = rs.markRoomAsReserved(roomNumbers);

        //Assert
        assertEquals(value, result);
    }


    @Test
    public void mustReturnAListOfVacantRoomsIfAnyRoomsFitTheCriteriaWhenCalled() {
        //Arrange
        List<RoomDTO> list = new ArrayList();
        list.add(new RoomDTO());
        var returnedFromTemplate = new ResponseEntity<List>(list, HttpStatus.OK);
        var restTemplateMock = mock(RestTemplate.class);
        when(restTemplateMock.getForEntity(anyString(), any(Class.class), (Object) anyVararg()))
                .thenReturn((ResponseEntity)returnedFromTemplate);

        RoomService rs = new RoomService(restTemplateMock);

        //Act
        ArrayList<RoomDTO> result = (ArrayList<RoomDTO>) rs.findVacantRooms(new VacantRoomsDTO());

        //Assert
        assertEquals(1, result.size());
    }





}
