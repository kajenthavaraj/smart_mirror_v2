package com.example.smartmirror.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class MirrorController {

    @GetMapping("/api/time")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    @GetMapping("/api/date")
    public String getDate() {
        // Return the date in the format of "Monday, 17th July 2025"    
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d'th' MMMM yyyy");
        // return LocalDateTime.now().format(formatter);

        return "Monday, July 17th 2025";
    }

    @GetMapping("/api/weather")
    public String[] getWeather() {
        return new String[]{"25°C", "Sunny"};
    }
}
