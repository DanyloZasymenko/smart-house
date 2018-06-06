package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.service.AndroidService;
import com.smarthouse.smarthouse.service.ArduinoService;
import com.smarthouse.smarthouse.service.DeviceService;
import com.smarthouse.smarthouse.service.utils.AlertButtons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AndroidServiceImpl implements AndroidService {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ArduinoService arduinoService;

    @Override
    public Device changeActive(Long deviceId, Boolean active) {
        Device device = deviceService.findOne(deviceId);
        arduinoService.changeDevice(device.setActive(active));
        return deviceService.save(device.setActive(active));
    }

    @Override
    public void getTemperature() {
    }

    @Override
    public AlertButtons checkAlert() {
        return AlertButtons.getInstance();
    }

    @Override
    public AlertButtons alert(Boolean fire, Boolean police) {
        return AlertButtons.getInstance()
                .setFire(fire)
                .setPolice(police);
    }
}
