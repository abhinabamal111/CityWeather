package com.weather.cityWeather.model;

public class City {
	
	private String cityId;
	private String cityName;
	private CityCoord co;
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public CityCoord getCo() {
		return co;
	}
	public void setCo(CityCoord co) {
		this.co = co;
	}
	
	

}
