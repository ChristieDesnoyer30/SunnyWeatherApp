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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        Forecast forecast = weatherService.fetchWeatherData("Chicago");
        Temperature temperature = forecast.getTemperature();
        double tempInFarhenheit = (temperature.getTemp() * 9/5 - 459.67);
        DecimalFormat df = new DecimalFormat("#.##");
        df.format(tempInFarhenheit);
        SunTimes sunTimes = forecast.getSunTimes();


Date sunRise = new Date(sunTimes.getSunrise()*1000);
Date sunSet = new Date(sunTimes.getSunset()*1000);
DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");


        mv.addObject("cityName","The current temperature in " + forecast.getName()
                + " is " + df.format(tempInFarhenheit) + "." + " The current humidity is " + temperature.getHumidity()
                + " %. Sunrise was at " +  dateFormat.format(sunRise)+ ". Sunset will be at " + dateFormat.format(sunSet)
        );

        return mv;
    }
}

