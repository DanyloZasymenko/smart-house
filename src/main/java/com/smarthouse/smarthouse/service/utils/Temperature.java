package com.smarthouse.smarthouse.service.utils;

public class Temperature {

    private Float humidity = 0.0f;
    private Float temperatureC = 0.0f;
    private Float temperatureF = 0.0f;
    private Float heatIndexC = 0.0f;
    private Float heatIndexF = 0.0f;

    public Temperature() {
    }

    private static Temperature instance = new Temperature();

    public static Temperature getInstance() {
        return instance;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Temperature setHumidity(Float humidity) {
        this.humidity = humidity;
        return this;
    }

    public Float getTemperatureC() {
        return temperatureC;
    }

    public Temperature setTemperatureC(Float temperatureC) {
        this.temperatureC = temperatureC;
        return this;
    }

    public Float getTemperatureF() {
        return temperatureF;
    }

    public Temperature setTemperatureF(Float temperatureF) {
        this.temperatureF = temperatureF;
        return this;
    }

    public Float getHeatIndexC() {
        return heatIndexC;
    }

    public Temperature setHeatIndexC(Float heatIndexC) {
        this.heatIndexC = heatIndexC;
        return this;
    }

    public Float getHeatIndexF() {
        return heatIndexF;
    }

    public Temperature setHeatIndexF(Float heatIndexF) {
        this.heatIndexF = heatIndexF;
        return this;
    }

    public static void setInstance(Temperature instance) {
        Temperature.instance = instance;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "humidity=" + humidity + " %" +
                ", temperatureC=" + temperatureC + " *C" +
                ", temperatureF=" + temperatureF + " *F" +
                ", heatIndexC=" + heatIndexC + " *C" +
                ", heatIndexF=" + heatIndexF + " *F" +
                '}';
    }
}
