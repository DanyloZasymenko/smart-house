package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.Device;

import java.util.List;

public interface DeviceService {

    Device save(Device device);

    Device update(Device device);

    Device findOne(Long id);

    List<Device> findAll();

    Boolean delete(Long id);

    Device findByNameAndHouseId(String name, Long houseId);

    List<Device> findAllByHouseId(Long houseId);

    List<Device> findAllByActiveAndHouseId(Boolean active, Long houseId);
}
