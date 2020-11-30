package com.example.demo.Service;

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

    static RestTemplate restTemplate = new RestTemplate();
    static final String URL = "";


    @Override
    public Collection<RoomDTO> findVacantRooms(VacantRoomsDTO vacantRoomsDTO) {

        VacantRoomsDTO dto = new VacantRoomsDTO();
        ResponseEntity<Collection> entity = restTemplate.getForEntity(URL, Collection.class, vacantRoomsDTO);
        return entity.getBody();
    }

    @Override
    public boolean markRoomAsReserved(List<String> list) {

        //return true;

        ResponseEntity<Boolean> entity = restTemplate.postForEntity(URL, list, Boolean.class);
        return entity.getBody();
    }
}
