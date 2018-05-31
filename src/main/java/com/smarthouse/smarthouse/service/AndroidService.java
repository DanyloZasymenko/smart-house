package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.Device;

public interface AndroidService {

    Device changeActive(Long deviceId, Boolean active);

    void getTemperature();
}
