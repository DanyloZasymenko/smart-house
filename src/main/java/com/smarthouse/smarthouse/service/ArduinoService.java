package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.service.utils.AlertButtons;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface ArduinoService {

    Device check();

    void changeDevice(Device device);

    Boolean confirmActivity(String serial);

    void getDataFromSensor(Float humidity, Float temperatureC, Float temperatureF, Float heatIndexC, Float heatIndexF);

    AlertButtons checkAlert();

    AlertButtons alert(Boolean fire, Boolean police);
}
