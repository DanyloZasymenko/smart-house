package com.smarthouse.smarthouse.model;

import javax.persistence.*;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.REFRESH)
    private User user;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Device device;
    @OneToOne(cascade = CascadeType.REFRESH)
    private ClimateConfig climateConfig;
    @OneToOne(cascade = CascadeType.REFRESH)
    private LightConfig lightConfig;

    public Long getId() {
        return id;
    }

    public UserData setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserData setUser(User user) {
        this.user = user;
        return this;
    }

    public Device getDevice() {
        return device;
    }

    public UserData setDevice(Device device) {
        this.device = device;
        return this;
    }

    public ClimateConfig getClimateConfig() {
        return climateConfig;
    }

    public UserData setClimateConfig(ClimateConfig climateConfig) {
        this.climateConfig = climateConfig;
        return this;
    }

    public LightConfig getLightConfig() {
        return lightConfig;
    }

    public UserData setLightConfig(LightConfig lightConfig) {
        this.lightConfig = lightConfig;
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", device=" + device.getId() +
                ", climateConfig=" + climateConfig.getId() +
                ", lightConfig=" + lightConfig.getId() +
                '}';
    }
}
