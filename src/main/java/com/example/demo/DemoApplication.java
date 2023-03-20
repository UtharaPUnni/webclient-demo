package com.example.demo;

import com.example.demo.weatherclient.rest.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoApplication {

	private final WeatherService weatherService;

	public DemoApplication(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	//todo test remove this
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		var geo = weatherService.fetchLatLongByCity("Cochin");
		var some = weatherService.fetchWeather(geo.results().get(0));
		System.out.println(some);
	}

}
