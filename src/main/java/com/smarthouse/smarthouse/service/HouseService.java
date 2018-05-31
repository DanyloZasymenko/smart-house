package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.House;

import java.security.Principal;
import java.util.List;

public interface HouseService {

    House save(House house);

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

    House createOrFindBySerial(String serial, Principal principal);
}
