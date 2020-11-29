package com.example.demo.Service;

import dto.RoomDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.RoomUtility;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class RoomService implements RoomUtility {

    static RestTemplate restTemplate = new RestTemplate();
    static final String URL = "http://localhost:8080/ISBN/";


    @Override
    public Collection<RoomDTO> findVacantRooms(int i, Date date, int i1) {

        VacantRoomsDTO dto = new VacantRoomsDTO();
        ResponseEntity<Collection> entity = restTemplate.getForEntity(RESERVATION_URL, findVacantRoomsDTO, Collection.class);


        return entity.getBody();
    }

    @Override
    public boolean markRoomAsReserved(List<String> list) {

        ResponseEntity<Boolean> entity = restTemplate.postForEntity(RESERVATION_URL, list, Boolean.class);

        return entity.getBody();



    }
}
