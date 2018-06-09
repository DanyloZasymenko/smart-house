package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class UserFullDto extends UserShortDto<UserFullDto> {

    private HouseShortDto house;

    public HouseShortDto getHouse() {
        return house;
    }

    public UserFullDto setHouse(HouseShortDto house) {
        this.house = house;
        return this;
    }

    @Override
    public String toString() {
        return "UserFullDto{" +
                "house=" + (house == null ? "null" : house.getId()) +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
