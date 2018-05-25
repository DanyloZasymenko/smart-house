package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;
import com.smarthouse.smarthouse.model.ClimateConfig;

@Dto
public class UserDataClimateDto extends UserDataShortDto<UserDataClimateDto> {

    private ClimateConfig climateConfig;

    public ClimateConfig getClimateConfig() {
        return climateConfig;
    }

    public UserDataClimateDto setClimateConfig(ClimateConfig climateConfig) {
        this.climateConfig = climateConfig;
        return this;
    }

    @Override
    public String toString() {
        return "UserDataClimateDto{" +
                "climateConfig=" + climateConfig.getId() +
                ", id=" + id +
                ", user=" + user.getId() +
                ", device=" + device.getId() +
                '}';
    }
}
