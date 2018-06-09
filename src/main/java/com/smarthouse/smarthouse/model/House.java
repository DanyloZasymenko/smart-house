package com.smarthouse.smarthouse.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String serial;
    private Boolean active;
    private Boolean online;
    private Timestamp dateOnline;
    private Float temperature;
    private Float humidity;
    @OneToMany(mappedBy = "house", cascade = CascadeType.REMOVE)
    private List<Device> devices;
    @OneToMany(mappedBy = "house", cascade = CascadeType.REFRESH)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public House setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public House setName(String name) {
        this.name = name;
        return this;
    }

    public String getSerial() {
        return serial;
    }

    public House setSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public House setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Boolean getOnline() {
        return online;
    }

    public House setOnline(Boolean online) {
        this.online = online;
        return this;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public House setDevices(List<Device> devices) {
        this.devices = devices;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public House setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public Timestamp getDateOnline() {
        return dateOnline;
    }

    public House setDateOnline(Timestamp dateOnline) {
        this.dateOnline = dateOnline;
        return this;
    }

    public Float getTemperature() {
        return temperature;
    }

    public House setTemperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }

    public Float getHumidity() {
        return humidity;
    }

    public House setHumidity(Float humidity) {
        this.humidity = humidity;
        return this;
    }


    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                ", active=" + active +
                ", online=" + online +
                ", dateOnline=" + dateOnline +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", devices=" + devices.stream().map(Device::getId).collect(toList()) +
                ", users=" + users.stream().map(User::getId).collect(toList()) +
                '}';
    }
}
