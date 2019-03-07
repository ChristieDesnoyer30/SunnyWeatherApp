package com.detroitlabs.sunnyday.controller;

import com.detroitlabs.sunnyday.Service.WeatherService;
import com.detroitlabs.sunnyday.model.Forecast;
import com.detroitlabs.sunnyday.model.SunTimes;
import com.detroitlabs.sunnyday.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;


    //“The current temperature in [CITY] is [NUMBER] degrees Fahrenheit.
    // The current humidity is [NUMBER] %. Sunrise was at [TIME] and sunset will be at [TIME].”

    @ResponseBody
    @RequestMapping("/")
    public ModelAndView displayWeather() {
        ModelAndView mv = new ModelAndView("home");

        Forecast forecast = weatherService.fetchWeatherData();
        Temperature temperature = forecast.getTemperature();
        double tempInFarhenheit = (temperature.getTemp() * 9/5 - 459.67);
        SunTimes sunTimes = forecast.getSunTimes();

        mv.addObject("cityName","The current temperature in " + forecast.getName()
                + " is " + tempInFarhenheit + "." + " The current humidity is " + temperature.getHumidity()
                + " %. Sunrise was at " +  sunTimes.getSunrise() + ". Sunset will be at " + sunTimes.getSunset()

        );

        return mv;
    }
}

