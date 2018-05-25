package com.smarthouse.smarthouse.service;

public interface ArduinoService {

    String check();

    void changeDevice(Integer pin, Boolean status);
}
