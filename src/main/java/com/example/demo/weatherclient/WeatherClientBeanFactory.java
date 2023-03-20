package com.example.demo.weatherclient;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Uthara
 * @since 10-03-2023
 **/

@Component
public class WeatherClientBeanFactory {

    @Bean
    public WebClient geoClient(){
        return WebClient.create("https://geocoding-api.open-meteo.com");
    }

    @Bean
    public WebClient weatherClient(){
        return WebClient.create("https://api.open-meteo.com");
    }
}
