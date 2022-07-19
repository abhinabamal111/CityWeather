package com.weather.cityWeather.dao;

import com.weather.cityWeather.model.CountryCityModel;

public interface CityWEatherDao {
	
	public CountryCityModel getCityListAsPerCountryDao(String countryCode);

}
