package com.example.demo.weatherclient.dto;

/**
 * @author Uthara
 * @since 10-03-2023
 **/
public record CurrentWeather(String temperature,String windspeed,String winddirection,String weathercode,String time) { }
