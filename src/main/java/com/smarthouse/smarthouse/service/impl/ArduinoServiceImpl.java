package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.model.House;
import com.smarthouse.smarthouse.service.ArduinoService;
import com.smarthouse.smarthouse.service.DeviceService;
import com.smarthouse.smarthouse.service.HouseService;
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
//        Integer tempInt = this.pin;
//        Boolean tempBool = this.status;
//        if (tempInt != -1) {
//            this.pin = -1;
//            this.status = false;
//            if (tempBool)
//                return tempInt + "_1";
//            else
//                return tempInt + "_0";
//        } else
//            return tempInt + "";
        Device temp = this.device;
        this.device = null;
        return temp;
    }

    @Override
    public void changeDevice(Device device) {
//        this.pin = pin;
//        this.status = status;
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

    @Scheduled(fixedDelay = 15000)
    private void scheduler() {
        houseService.findAll().stream().filter(house ->
                house.getDateOnline().toLocalDateTime().isBefore(LocalDateTime.now().minusSeconds(15)) || house.getDateOnline().toLocalDateTime().equals(LocalDateTime.now().minusSeconds(15)))
                .forEach(house -> {
                    houseService.update(house.setOnline(false));
                });
    }

    @Override
    public void getDataFromSensor(Float humidity, Float temperatureC, Float temperatureF, Float heatIndexC, Float heatIndexF) {
        System.err.print("Humidity: ");
        System.err.print(humidity);
        System.err.print(" %\t");
        System.err.print("Temperature: ");
        System.err.print(temperatureC);
        System.err.print(" *C ");
        System.err.print(temperatureF);
        System.err.print(" *F\t");
        System.err.print("Heat index: ");
        System.err.print(heatIndexC);
        System.err.print(" *C ");
        System.err.print(heatIndexF);
        System.err.println(" *F");
    }
}
