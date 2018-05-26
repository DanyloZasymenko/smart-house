package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.repository.DeviceRepository;
import com.smarthouse.smarthouse.repository.HouseRepository;
import com.smarthouse.smarthouse.service.DeviceService;
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

    @Override
    public Device save(Device device) {
        checkSave(device);
        return deviceRepository.save(device);
    }

    @Override
    public Device update(Device device) {
        checkObjectExistsById(device.getId(), deviceRepository);
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
