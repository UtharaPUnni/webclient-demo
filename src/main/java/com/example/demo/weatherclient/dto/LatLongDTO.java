package com.example.demo.weatherclient.dto;

import java.util.List;

/**
 * @author Uthara
 * @since 10-03-2023
 **/
public record LatLongDTO(List<CityGeoInfoDTO> results) { }
