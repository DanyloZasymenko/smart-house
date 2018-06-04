package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class UserShortDto<T extends UserShortDto> {

    protected Long id;
    protected String email;
    protected String password;
    protected String name;
    protected String middleName;
    protected String lastName;
    protected Float temperature;

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public String getEmail() {
        return email;
    }

    public T setEmail(String email) {
        this.email = email;
        return (T) this;
    }

    public String getPassword() {
        return password;
    }

    public T setPassword(String password) {
        this.password = password;
        return (T) this;
    }

    public String getName() {
        return name;
    }

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public T setMiddleName(String middleName) {
        this.middleName = middleName;
        return (T) this;
    }

    public String getLastName() {
        return lastName;
    }

    public T setLastName(String lastName) {
        this.lastName = lastName;
        return (T) this;
    }

    public Float getTemperature() {
        return temperature;
    }

    public T setTemperature(Float temperature) {
        this.temperature = temperature;
        return (T) this;
    }

    @Override
    public String toString() {
        return "UserShortDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
