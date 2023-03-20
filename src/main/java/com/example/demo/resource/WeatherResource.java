package com.example.demo.resource;

import com.example.demo.weatherclient.dto.CurrentWeather;
import com.example.demo.weatherclient.rest.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Uthara
 * @since 13-03-2023
 **/

@RequestMapping("/api/v1")
@RestController
public class WeatherResource {

    private final WeatherService weatherService;

    public WeatherResource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current-weather/{city-name}")
    public CurrentWeather fetchCurrentWeatherByCity(@PathVariable("city-name") String cityName) {
        return weatherService.fetchWeather(weatherService.fetchLatLongByCity(cityName).results().get(3)).currentWeather();
    }
}
