package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.model.enums.DeviceType;
import com.smarthouse.smarthouse.repository.DeviceRepository;
import com.smarthouse.smarthouse.repository.HouseRepository;
import com.smarthouse.smarthouse.service.DeviceService;
import com.smarthouse.smarthouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseService houseService;

    @Override
    public Device save(Device device) {
        checkSave(device);
        return deviceRepository.save(device.setActive(false));
    }

    @Override
    public Device save(String name, Integer pin, String deviceType, Long houseId) {
        return deviceRepository.save(new Device()
                .setName(name)
                .setPin(pin)
                .setDeviceType(DeviceType.valueOf(deviceType))
                .setHouse(houseService.findOne(houseId))
                .setActive(false));
    }

    @Override
    public Device update(Long id, String name, Integer pin, String deviceType, Long houseId) {
        checkObjectExistsById(id, deviceRepository);
        Device device = findOne(id)
                .setName(name)
                .setPin(pin)
                .setDeviceType(DeviceType.valueOf(deviceType))
                .setHouse(houseService.findOne(houseId));
        return deviceRepository.save(device);
    }

    @Override
    public Device findOne(Long id) {
        checkId(id);
        return deviceRepository.findOne(id);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            checkObjectExistsById(id, deviceRepository);
            deviceRepository.delete(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public Device findByNameAndHouseId(String name, Long houseId) {
        checkString(name);
        checkObjectExistsById(houseId, houseRepository);
        return deviceRepository.findByNameAndHouse_Id(name, houseId);
    }

    @Override
    public List<Device> findAllByHouseId(Long houseId) {
        checkObjectExistsById(houseId, houseRepository);
        return deviceRepository.findAllByHouse_Id(houseId);
    }

    @Override
    public List<Device> findAllByActiveAndHouseId(Boolean active, Long houseId) {
        checkObjectExistsById(houseId, houseRepository);
        return deviceRepository.findAllByActiveAndHouse_Id(active, houseId);
    }
}
