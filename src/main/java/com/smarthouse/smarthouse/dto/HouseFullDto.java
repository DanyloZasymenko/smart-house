package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Dto
public class HouseFullDto extends HouseShortDto<HouseFullDto>{

    private List<DeviceShortDto> devices;
    private List<UserShortDto> users;

    public List<DeviceShortDto> getDevices() {
        return devices;
    }

    public HouseFullDto setDevices(List<DeviceShortDto> devices) {
        this.devices = devices;
        return this;
    }

    public List<UserShortDto> getUsers() {
        return users;
    }

    public HouseFullDto setUsers(List<UserShortDto> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "HouseFullDto{" +
                "devices=" + devices.stream().map(DeviceShortDto::getId).collect(toList()) +
                ", users=" + users.stream().map(UserShortDto::getId).collect(toList()) +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
