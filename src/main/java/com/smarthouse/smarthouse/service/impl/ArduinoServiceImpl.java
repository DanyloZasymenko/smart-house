package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.model.House;
import com.smarthouse.smarthouse.service.ArduinoService;
import com.smarthouse.smarthouse.service.DeviceService;
import com.smarthouse.smarthouse.service.HouseService;
import com.smarthouse.smarthouse.service.utils.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    private static Integer pin = -1;
    private static Boolean status = false;
    private static Device device;

    @Autowired
    private HouseService houseService;
    @Autowired
    private DeviceService deviceService;

    @Override
    public Device check() {
        Device temp = this.device;
        this.device = null;
//        System.err.println(temp);
        return temp;
    }

    @Override
    public void changeDevice(Device device) {
        this.device = device;
    }

    @Override
    public Boolean confirmActivity(String serial) {
        House house = houseService.findBySerial(serial);
        if (house != null) {
            house.setActive(true);
            house.setOnline(true);
            house.setDateOnline(Timestamp.valueOf(LocalDateTime.now()));
            houseService.update(house);
            return true;
        } else
            return false;
    }

    @Scheduled(fixedDelay = 10000)
    private void scheduler() {
        houseService.findAll().stream().filter(house ->
                house.getDateOnline().toLocalDateTime().isBefore(LocalDateTime.now().minusSeconds(10)) || house.getDateOnline().toLocalDateTime().equals(LocalDateTime.now().minusSeconds(10)))
                .forEach(house -> {
                    houseService.update(house.setOnline(false));
                });
    }

    @Override
    public void getDataFromSensor(Float humidity, Float temperatureC, Float temperatureF, Float heatIndexC, Float heatIndexF) {
        try {
            Temperature.getInstance()
                    .setHumidity(humidity)
                    .setTemperatureC(temperatureC)
                    .setTemperatureF(temperatureF)
                    .setHeatIndexC(heatIndexC)
                    .setHeatIndexF(heatIndexF);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("-----------------------------------");
            System.err.println("error reading temperature");
            System.err.println("-----------------------------------");
        }
//        System.err.println(Temperature.getInstance().toString());
    }
}
