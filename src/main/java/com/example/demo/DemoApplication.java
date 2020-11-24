package com.example.demo;

import Service.RMITest;
import dto.RoomDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import types.RoomType;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

@SpringBootApplication
@Controller
public class DemoApplication {

    @GetMapping("/")
    public String index(final Model model) throws RemoteException, MalformedURLException {
        RoomDTO room = new RoomDTO(null, "24", RoomType.F);
        model.addAttribute("title", "Docker + Spring Boot");
        model.addAttribute("msg", "This is the RoomDTO properties: " + room.getRoomNumber() + room.getRoomType());

        var RMI = new RMITest();
        System.out.println(RMI.createBooking());
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
