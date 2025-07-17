package com.example.smartmirror.service;

import com.example.smartmirror.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    
    public WeatherData getWeather() {
        String url = String.format("%s?lat=43.6532&lon=79.3832&appid=%s&units=metric", BASE_URL, apiKey);
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(WeatherData.class)
                .block();
    }
} 