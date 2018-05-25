package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class DeviceFullDto extends DeviceShortDto<DeviceFullDto> {

    private HouseShortDto house;

    public HouseShortDto getHouse() {
        return house;
    }

    public DeviceFullDto setHouse(HouseShortDto house) {
        this.house = house;
        return this;
    }

    @Override
    public String toString() {
        return "DeviceFullDto{" +
                "house=" + house.getId() +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", pin=" + pin +
                ", deviceType=" + deviceType +
                ", isActive=" + isActive +
                '}';
    }
}
