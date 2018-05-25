package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.service.ArduinoService;
import com.smarthouse.smarthouse.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    private static Integer pin = -1;
    private static Boolean status = false;

    @Autowired
    private DeviceService deviceService;

    @Override
    public String check() {
        Integer temp = this.pin;
        Boolean temp1 = this.status;
        if (temp != -1) {
            this.pin = -1;
            this.status = false;
            if (temp1 == true)
                return temp + " 1";
            else
                return temp + " 0";
        } else
            return temp + "";
    }

    @Override
    public void changeDevice(Integer pin, Boolean status) {
        this.pin = pin;
        this.status = status;
    }
}
