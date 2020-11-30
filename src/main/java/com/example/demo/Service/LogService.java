package com.example.demo.Service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class LogService {


    public List<String> fetchLogs() {

        List<String> list = new ArrayList<>();

        try {
            File myObj = new File(System.getProperty("user.dir") + "/src/main/resources/logs/log4j-application.log");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }
}
