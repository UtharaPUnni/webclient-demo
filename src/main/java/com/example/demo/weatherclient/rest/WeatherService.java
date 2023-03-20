package com.example.demo.weatherclient.rest;

import com.example.demo.weatherclient.dto.CityGeoInfoDTO;
import com.example.demo.weatherclient.dto.LatLongDTO;
import com.example.demo.weatherclient.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author uthara
 * @since 14-03-2023
 **/
@Service
public class WeatherService {

    private final WebClient geoClient;
    private final WebClient weatherClient;

    public WeatherService(WebClient geoClient, WebClient weatherClient) {
        this.geoClient = geoClient;
        this.weatherClient = weatherClient;
    }


    public LatLongDTO fetchLatLongByCity(String city){
        return geoClient.get()
                .uri(uriBuilder -> uriBuilder.path("v1/search")
                        .queryParam("name",city)
                        .build())
                .retrieve()
                .bodyToMono(LatLongDTO.class).block();
    }

    public WeatherResponseDTO fetchWeather(CityGeoInfoDTO city){
        return weatherClient.get()
                .uri(uriBuilder -> uriBuilder.path("v1/forecast")
                        .queryParam("latitude",city.latitude())
                        .queryParam("longitude",city.longitude())
                        .query("current_weather=true")
                        .build()).retrieve().bodyToMono(WeatherResponseDTO.class)
                .block();
    }
}
