package com.example.demo.weatherclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Uthara
 * @since 10-03-2023
 **/
public record WeatherResponseDTO(@JsonProperty("current_weather") CurrentWeather currentWeather) {
}
