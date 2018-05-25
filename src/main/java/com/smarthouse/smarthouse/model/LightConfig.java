package com.smarthouse.smarthouse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class LightConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time startTime;
    private Time endTime;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public LightConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public Time getStartTime() {
        return startTime;
    }

    public LightConfig setStartTime(Time startTime) {
        this.startTime = startTime;
        return this;
    }

    public Time getEndTime() {
        return endTime;
    }

    public LightConfig setEndTime(Time endTime) {
        this.endTime = endTime;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public LightConfig setActive(Boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public String toString() {
        return "LightConfig{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", active=" + active +
                '}';
    }
}
