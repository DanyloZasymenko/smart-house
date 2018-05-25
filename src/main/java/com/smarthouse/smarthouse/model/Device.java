package com.smarthouse.smarthouse.model;

import com.smarthouse.smarthouse.model.enums.DeviceType;

import javax.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer pin;
    private DeviceType deviceType;
    private Boolean isActive;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private House house;

    public Long getId() {
        return id;
    }

    public Device setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPin() {
        return pin;
    }

    public Device setPin(Integer pin) {
        this.pin = pin;
        return this;
    }

    public House getHouse() {
        return house;
    }

    public Device setHouse(House house) {
        this.house = house;
        return this;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public Device setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Device setActive(Boolean active) {
        isActive = active;
        return this;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pin=" + pin +
                ", deviceType=" + deviceType +
                ", isActive=" + isActive +
                ", house=" + house.getId() +
                '}';
    }
}
