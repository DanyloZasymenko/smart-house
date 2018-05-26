package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.Device;

public interface ArduinoService {

    Device check();

    void changeDevice(Device device);

    Boolean confirmActivity(String serial);

    void getDataFromSensor(Float humidity, Float temperatureC, Float temperatureF, Float heatIndexC, Float heatIndexF);
}
