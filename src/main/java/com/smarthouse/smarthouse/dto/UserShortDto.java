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

    public UserShortDto<T> setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserShortDto<T> setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserShortDto<T> setName(String name) {
        this.name = name;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public UserShortDto<T> setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserShortDto<T> setLastName(String lastName) {
        this.lastName = lastName;
        return this;
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
                '}';
    }
}
