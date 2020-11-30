package com.example.demo.Service;

import com.example.demo.URLs;
import dto.RoomDTO;
import dto.VacantRoomsDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.RoomUtility;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Service
public class RoomService implements RoomUtility {

    static RestTemplate restTemplate;

    public RoomService() {
        restTemplate = new RestTemplate();
    }

    public RoomService(RestTemplate template) {
        restTemplate = template;
    }

    @Override
    public Collection<RoomDTO> findVacantRooms(VacantRoomsDTO vacantRoomsDTO) {
        ResponseEntity<Collection> entity = restTemplate.getForEntity(URLs.BACKEND_URL + "room", Collection.class,vacantRoomsDTO);
        return entity.getBody();
    }

    @Override
    public boolean markRoomAsReserved(List<String> list) {

        ResponseEntity<Boolean> entity = restTemplate.postForEntity(URLs.BACKEND_URL + "room", list, Boolean.class);
        return entity.getBody();
    }
}
