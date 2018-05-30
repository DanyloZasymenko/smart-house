package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.House;
import com.smarthouse.smarthouse.repository.HouseRepository;
import com.smarthouse.smarthouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.checkId;
import static com.smarthouse.smarthouse.service.utils.Validation.checkObjectExistsById;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public House save(String name,
                      String serial) {
        return houseRepository.save(new House()
                .setName(name)
                .setSerial(serial)
                .setActive(true));
    }

    @Override
    public House update(House house) {
        checkObjectExistsById(house.getId(), houseRepository);
        return houseRepository.save(house);
    }

    @Override
    public House update(Long id,
                        String name,
                        String serial) {
        checkObjectExistsById(id, houseRepository);
        House house = findOne(id)
                .setName(name)
                .setSerial(serial);
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
