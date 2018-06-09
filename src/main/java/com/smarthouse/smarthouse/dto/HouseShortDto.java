package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class HouseShortDto<T extends HouseShortDto> {

    protected Long id;
    protected String name;
    protected String serial;
    protected Boolean active;
    protected Boolean online;
    protected Float temperature;
    protected Float humidity;

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public String getSerial() {
        return serial;
    }

    public T setSerial(String serial) {
        this.serial = serial;
        return (T) this;
    }

    public Boolean getActive() {
        return active;
    }

    public T setActive(Boolean active) {
        this.active = active;
        return (T) this;
    }

    public Boolean getOnline() {
        return online;
    }

    public T setOnline(Boolean online) {
        this.online = online;
        return (T) this;
    }

    public Float getTemperature() {
        return temperature;
    }

    public T setTemperature(Float temperature) {
        this.temperature = temperature;
        return (T) this;
    }

    public Float getHumidity() {
        return humidity;
    }

    public T setHumidity(Float humidity) {
        this.humidity = humidity;
        return (T) this;
    }

    @Override
    public String toString() {
        return "HouseShortDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                ", active=" + active +
                ", online=" + online +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
