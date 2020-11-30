package com.example.demo.Controller;

import com.example.demo.Service.RoomService;
import dto.RoomDTO;
import dto.VacantRoomsDTO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Room")
public class RoomController {

    final Logger logger = Logger.getLogger(HotelController.class);

    final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
        logger.info("Constructor called");
    }

    @GetMapping("/VacantRooms/{hotelNumber}/{date}/{numberOfGuests}")
    public Collection<RoomDTO> findVacantRooms(@PathVariable int hotelNumber, @PathVariable String date, @PathVariable int numberOfGuests) throws ParseException {
        logger.info("findVacantRooms - called");
        Date date1 = new SimpleDateFormat("dd-MM-YYYY").parse(date);
        VacantRoomsDTO dto = new VacantRoomsDTO(hotelNumber, date1, numberOfGuests);
        return roomService.findVacantRooms(dto);
    }

    @PutMapping("/{roomNumber}")
    public boolean markRoomAsReserved(@PathVariable List<String> roomNumber){
        logger.info("markRoomAsReserved - called");
        return roomService.markRoomAsReserved(roomNumber);
    }
}
