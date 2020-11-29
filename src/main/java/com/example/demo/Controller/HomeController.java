package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.log4j.Logger;

@Controller
public class HomeController {

    private final static Logger logger = Logger.getLogger(HomeController.class);

    public HomeController() {
        logger.info("Constructor called");
    }

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "Docker + Spring Boot");
        model.addAttribute("msg", "We used to do RMI, but not we're using REST!");
        logger.info("index.html successfully loaded");
        return "index";
    }

}
