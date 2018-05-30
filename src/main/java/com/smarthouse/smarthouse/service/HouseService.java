package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.House;

import java.sql.Timestamp;
import java.util.List;

public interface HouseService {

    House save(String name,
               String serial);

    House update(House house);

    House update(Long id,
                 String name,
                 String serial);

    House findOne(Long id);

    List<House> findAll();

    Boolean delete(Long id);

    House findBySerial(String serial);
}
