package com.weather.cityWeather.controller;

import org.springframework.web.bind.annotation.RestController;

import com.weather.cityWeather.model.CountryCityModel;
import com.weather.cityWeather.service.CityWeatherInterface;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("cityWeather")
public class CityWeatherController {
	
	@Autowired
	private CityWeatherInterface cityWeatherInterface;

	@GetMapping("/cityList/{country}")
	public ResponseEntity<?> getCityList(@PathVariable("country") String country)
	{
		
		CountryCityModel countryCityModel = cityWeatherInterface.getCityListAsPerCountry(country);
		
			JSONObject jo = new JSONObject();
			
			
			
			jo.put(countryCityModel.getCountryCode(), countryCityModel.getCity());
			
			//jo.t
		
		//System.out.println(cc.getCity());
		
		return new ResponseEntity<>(jo.toString(),HttpStatus.OK);
	}
}
