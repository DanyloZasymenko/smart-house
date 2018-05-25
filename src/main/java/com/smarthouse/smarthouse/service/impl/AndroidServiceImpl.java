package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.service.AndroidService;
import com.smarthouse.smarthouse.service.ArduinoService;
import com.smarthouse.smarthouse.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AndroidServiceImpl implements AndroidService{

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ArduinoService arduinoService;

    @Override
    public Device changeActive(Long deviceId, Boolean active) {
        Device device = deviceService.findOne(deviceId);
        arduinoService.changeDevice(device.getPin(), active);
        return deviceService.save(device.setActive(active));
    }
}
