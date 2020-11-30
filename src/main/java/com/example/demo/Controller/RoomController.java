package com.example.demo.Controller;

import com.example.demo.Service.RoomService;
import dto.RoomDTO;
import dto.VacantRoomsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    final Logger logger = Logger.getLogger(RoomController.class);

    final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
        logger.info("Constructor called");
    }

    @GetMapping("")
    public Collection<RoomDTO> findVacantRooms(@RequestBody VacantRoomsDTO vacantRoomsDTO) {
        logger.info("findVacantRooms - called");
        return roomService.findVacantRooms(vacantRoomsDTO);
    }

    @PutMapping("")
    public boolean markRoomAsReserved(@RequestBody List<String> roomNumber){
        logger.info("markRoomAsReserved - called");
        return roomService.markRoomAsReserved(roomNumber);
    }
}
