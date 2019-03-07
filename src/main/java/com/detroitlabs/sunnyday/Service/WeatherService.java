package com.detroitlabs.sunnyday.Service;

import com.detroitlabs.sunnyday.model.Forecast;
import com.detroitlabs.sunnyday.model.Temperature;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    public Forecast fetchWeatherData(){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" +
                "Detroit&APPID=d016ac69111dabafef719181aa4ab8ca", Forecast.class);
    }



}
