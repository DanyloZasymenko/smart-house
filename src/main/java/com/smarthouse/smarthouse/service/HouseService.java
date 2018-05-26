package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.House;

import java.util.List;

public interface HouseService {

    House save(House house);

    House update(House house);

    House findOne(Long id);

    List<House> findAll();

    Boolean delete(Long id);

    House findBySerial(String serial);
}
