package com.example.demo.Controller;

import com.example.demo.Service.RoomService;
import dto.RoomDTO;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Room")
public class RoomController {

    final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/VacantRooms/{hotelNumber}/{date}/{numberOfGuests}")
    public Collection<RoomDTO> findVacantRooms(@PathVariable int hotelNumber, @PathVariable String date, @PathVariable int numberOfGuests) throws ParseException {
        Date date1 = new SimpleDateFormat("dd-MM-YYYY").parse(date);
        return roomService.findVacantRooms(hotelNumber, date1, numberOfGuests);
    }

    @PutMapping("/{roomNumber}")
    public boolean markRoomAsReserved(@PathVariable List<String> roomNumber){
        return roomService.markRoomAsReserved(roomNumber);
    }
}
