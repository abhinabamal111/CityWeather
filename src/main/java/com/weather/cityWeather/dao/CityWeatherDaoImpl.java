package com.weather.cityWeather.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;


//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import com.weather.cityWeather.model.City;
import com.weather.cityWeather.model.CityCoord;
import com.weather.cityWeather.model.CountryCityModel;


@Component
public class CityWeatherDaoImpl implements CityWEatherDao {

	@Override
	public CountryCityModel getCityListAsPerCountryDao(String countryCode) {
		// TODO Auto-generated method stub
		
		JSONArray j = null;
		
		CountryCityModel cc = new  CountryCityModel();
		
		try {
			
			  BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ABHMAL\\Downloads\\city-ids.json"));
			  
			  //ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\ABHMAL\\Downloads\\city-ids.json"));
			  
			  StringBuilder st = new StringBuilder();
			  String line = reader.readLine();
			  
			  String data=""; 
			  while (line != null) {
			        st.append(line);
			        st.append("\n");
			        line = reader.readLine();
			    }
			  data = st.toString();
			
			Set<Integer> s = new HashSet<>(); 
			
			//String data = null;
			
			  reader.close();
			  
			  //JSONObject object = new JSONObject();

			  
			  JSONArray arr = new JSONArray(data);

			// j = (JsonArray) new JsonParser().parse(data);
			 
			 int counter =0;
			 
			 
			 

			 List<City> cityList = new ArrayList<>();
			 
			 
			 for (int k=0; k < arr.length(); k++) {
				 
				 JSONObject m = arr.getJSONObject(k);
				 if(counter<10) {
					 
					 if(!countryCode.isEmpty()) {
					 
				 
						 //System.out.println("Country code from JSON: --"+m.get("country").toString());
						 //System.out.println("Country code as parameter: --"+countryCode);
						 
						 //System.out.println("Are both equal: ---------------- "+countryCode.equals(m.get("country").toString()) );
						 
				 if(m.get("country").toString().equalsIgnoreCase(countryCode))
				 {
					
					 
					 CityCoord cityCoord = new CityCoord();
					 JSONObject co = (JSONObject) m.get("coord");
					 
					 BigDecimal lon = (BigDecimal)co.get("lon");
					 BigDecimal lat = (BigDecimal)co.get("lat");
					 
					 
					 cityCoord.setLon(lon.longValue());
					 cityCoord.setLat(lat.longValue());
					 
					 City city = new City();
					 
					 int id = (int) m.get("id");
					 city.setCityId(String.valueOf(id));
					 city.setCityName((String)m.get("name"));
					 city.setCo(cityCoord);				
					 
					 cityList.add(city);
 
					 counter++;
					 cc.setCountryCode(countryCode);
					 	
					 
				 }
			}
					 else
					 {
						 CityCoord cityCoord = new CityCoord();
						 JSONObject co = (JSONObject)m.get("coord");
						 
						
						 BigDecimal lon = (BigDecimal)co.get("lon");
						 BigDecimal lat = (BigDecimal)co.get("lat");
								 
						 cityCoord.setLon(lon.longValue());
						 cityCoord.setLat(lat.longValue());
						 
						 City city = new City();
						 int id = (int) m.get("id");
						 city.setCityId(String.valueOf(id));
						 city.setCityId((String)m.get("id"));
						 city.setCityName((String)m.get("name"));
						 city.setCo(cityCoord);				
						 
						 cityList.add(city);
	 
						 counter++;
						 cc.setCountryCode(countryCode);
						 //cc.setCity(cityList);
					 }
		}
				
	}
			 cc.setCity(cityList);	 
			 	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return cc;
	}

}
