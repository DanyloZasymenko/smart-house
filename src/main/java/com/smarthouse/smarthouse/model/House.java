package com.smarthouse.smarthouse.model;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
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

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", devices=" + devices.stream().map(Device::getId).collect(toList()) +
                ", users=" + users.stream().map(User::getId).collect(toList()) +
                '}';
    }
}
