package com.weather.cityWeather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.cityWeather.dao.CityWEatherDao;
import com.weather.cityWeather.model.CountryCityModel;

@Service
public class CityWeatherImpl implements CityWeatherInterface {
	
	@Autowired
	private CityWEatherDao cityWEatherDao;

	@Override
	public CountryCityModel getCityListAsPerCountry(String countryCode) {
		// TODO Auto-generated method stub
		
		CountryCityModel countryCityModel = cityWEatherDao.getCityListAsPerCountryDao(countryCode);
		
		System.out.println(age);
		
		return countryCityModel;
	}

}
