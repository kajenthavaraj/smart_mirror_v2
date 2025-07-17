package com.example.smartmirror.controller;

import com.example.smartmirror.model.WeatherData;
import com.example.smartmirror.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class MirrorController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/time")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    @GetMapping("/api/date")
    public String getDate() {
        LocalDateTime now = LocalDateTime.now();
        String dayOfWeek = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String month = now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int day = now.getDayOfMonth();
        int year = now.getYear();

        // Determine ordinal suffix
        String suffix = "th";
        if (day % 10 == 1 && day != 11) suffix = "st";
        else if (day % 10 == 2 && day != 12) suffix = "nd";
        else if (day % 10 == 3 && day != 13) suffix = "rd";

        return String.format("%s, %s %d%s %d", dayOfWeek, month, day, suffix, year);
    }

    @GetMapping("/api/weather")
    public String[] getWeather() {
        try {
            WeatherData weather = weatherService.getWeather("Toronto"); // Change to your city
            return new String[]{
                String.format("%.0f°C", weather.getMain().getTemp()),
                weather.getWeather()[0].getMain()
            };
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"--°C", "Error"};
        }
    }
}
