package com.weather.cityWeather.service;

import org.springframework.stereotype.Service;

import com.weather.cityWeather.model.CountryCityModel;


public interface CityWeatherInterface {
	
	public int age=0;
	
	public CountryCityModel getCityListAsPerCountry(String countryCode);

}
