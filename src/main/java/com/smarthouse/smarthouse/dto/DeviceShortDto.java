package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;
import com.smarthouse.smarthouse.model.enums.DeviceType;

@Dto
public class DeviceShortDto<T extends DeviceShortDto> {

    protected Long id;
    protected String name;
    protected Integer pin;
    protected DeviceType deviceType;
    protected Boolean isActive;

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

    public Integer getPin() {
        return pin;
    }

    public T setPin(Integer pin) {
        this.pin = pin;
        return (T) this;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public T setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
        return (T) this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public T setActive(Boolean active) {
        isActive = active;
        return (T) this;
    }

    @Override
    public String toString() {
        return "DeviceShortDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pin=" + pin +
                ", deviceType=" + deviceType +
                ", isActive=" + isActive +
                '}';
    }
}
