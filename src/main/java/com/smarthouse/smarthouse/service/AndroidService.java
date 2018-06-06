package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.service.utils.AlertButtons;

public interface AndroidService {

    Device changeActive(Long deviceId, Boolean active);

    void getTemperature();

    AlertButtons checkAlert();

    AlertButtons alert(Boolean fire, Boolean police);
}
