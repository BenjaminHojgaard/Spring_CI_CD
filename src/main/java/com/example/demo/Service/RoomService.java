package com.example.demo.Service;

import dto.RoomDTO;
import dto.VacantRoomsDTO;
import org.springframework.stereotype.Service;
import service.RoomUtility;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Service
public class RoomService implements RoomUtility {
    @Override
    public Collection<RoomDTO> findVacantRooms(VacantRoomsDTO vacantRoomsDTO) {
        return null;
    }

    @Override
    public boolean markRoomAsReserved(List<String> list) {
        return false;
    }
}
