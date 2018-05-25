package com.smarthouse.smarthouse.dto;

import com.smarthouse.smarthouse.dto.utils.annotations.Dto;
import com.smarthouse.smarthouse.model.LightConfig;

@Dto
public class UserDataLightDto extends UserDataShortDto<UserDataLightDto> {

    private LightConfig lightConfig;

    public LightConfig getLightConfig() {
        return lightConfig;
    }

    public UserDataLightDto setLightConfig(LightConfig lightConfig) {
        this.lightConfig = lightConfig;
        return this;
    }

    @Override
    public String toString() {
        return "UserDataLightDto{" +
                "lightConfig=" + lightConfig.getId() +
                ", id=" + id +
                ", user=" + user.getId() +
                ", device=" + device.getId() +
                '}';
    }
}
