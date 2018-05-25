package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;

@Dto
public class UserFullDto extends UserShortDto<UserFullDto>{

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
                "house=" + house.getId() +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
