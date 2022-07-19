package com.weather.cityWeather.model;

import java.util.List;

//import com.example.demo.model.AnnotateInterface;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryCityModel {
	
	@JsonProperty
	private String countryCode;
	@JsonProperty
	private List<City> city;
	
	
	@AnnotateInterface
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
	
	
	

}
