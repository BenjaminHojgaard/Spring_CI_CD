package com.example.demo.Controller;


import com.example.demo.Service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("")
    public List<String> Get(){
        return logService.fetchLogs();
    }

}
