package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class UserDataShortDto<T extends UserDataShortDto> {

    protected Long id;
    protected UserShortDto user;
    protected DeviceShortDto device;

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public UserShortDto getUser() {
        return user;
    }

    public T setUser(UserShortDto user) {
        this.user = user;
        return (T) this;
    }

    public DeviceShortDto getDevice() {
        return device;
    }

    public T setDevice(DeviceShortDto device) {
        this.device = device;
        return (T) this;
    }

    @Override
    public String toString() {
        return "UserDataShortDto{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", device=" + device.getId() +
                '}';
    }
}
