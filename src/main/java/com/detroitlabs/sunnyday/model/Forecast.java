package com.detroitlabs.sunnyday.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private String name;

   private Temperature temperature;

   private SunTimes sunTimes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("main")
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty("main")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("sys")
    public SunTimes getSunTimes() {
        return sunTimes;
    }

    @JsonProperty("sys")
    public void setSunTimes(SunTimes sunTimes) {
        this.sunTimes = sunTimes;
    }
}
