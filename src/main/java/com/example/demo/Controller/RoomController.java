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
    public Collection<RoomDTO> findVacantRooms(@RequestParam int hotelNumber, @RequestParam Date date, @RequestParam int numberOfGuests) {
        logger.info("findVacantRooms - called");
        var vacantRoomsDTO = new VacantRoomsDTO(hotelNumber, date, numberOfGuests);
        return roomService.findVacantRooms(vacantRoomsDTO);
    }

    @PutMapping("")
    public boolean markRoomAsReserved(@RequestParam("param") List<String> roomNumber){
        logger.info("markRoomAsReserved - called");
        return roomService.markRoomAsReserved(roomNumber);
    }
}
