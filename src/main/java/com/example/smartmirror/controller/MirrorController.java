package com.example.smartmirror.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class MirrorController {

    @GetMapping("/api/time")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    @GetMapping("/api/weather")
    public String getWeather() {
        return "Sunny, 25°C"; // Hardcoded weather
    }
}
