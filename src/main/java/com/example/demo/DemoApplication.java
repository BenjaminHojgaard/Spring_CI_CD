package com.example.demo;

import dto.RoomDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import types.RoomType;

@SpringBootApplication
@Controller
public class DemoApplication {

    @GetMapping("/")
    public String index(final Model model) {
        RoomDTO room = new RoomDTO(null, "22", RoomType.F);
        model.addAttribute("title", "Docker + Spring Boot");
        model.addAttribute("msg", "This is the RoomDTO properties: " + room.getRoomNumber() + room.getRoomType());
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
