package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class DeviceToArduinoDto {

    private Integer pin;
    private Boolean active;

    public Integer getPin() {
        return pin;
    }

    public DeviceToArduinoDto setPin(Integer pin) {
        this.pin = pin;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public DeviceToArduinoDto setActive(Boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public String toString() {
        return "DeviceToArduinoDto{" +
                "pin=" + pin +
                ", active=" + active +
                '}';
    }
}
