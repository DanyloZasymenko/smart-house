package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.House;
import com.smarthouse.smarthouse.repository.HouseRepository;
import com.smarthouse.smarthouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public House save(House house) {
        checkSave(house);
        return houseRepository.save(house.setActive(true));
    }

    @Override
    public House update(House house) {
        checkObjectExistsById(house.getId(), houseRepository);
        return houseRepository.save(house);
    }

    @Override
    public House findOne(Long id) {
        checkId(id);
        return houseRepository.findOne(id);
    }

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            checkObjectExistsById(id, houseRepository);
            houseRepository.delete(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public House findBySerial(String serial) {
        return houseRepository.findBySerial(serial);
    }
}
