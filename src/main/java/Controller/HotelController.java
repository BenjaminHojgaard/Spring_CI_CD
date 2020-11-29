package Controller;

import Service.HotelService;
import dto.CreateBookingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class HotelController {

    final
    HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel")
    public boolean hotel() {
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        return hotelService.createBooking(
                new CreateBookingDTO(
                list,
                "",
                1,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
                true)
        );
    }
}
