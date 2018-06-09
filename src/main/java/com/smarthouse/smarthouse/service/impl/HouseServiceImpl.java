package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.House;
import com.smarthouse.smarthouse.model.User;
import com.smarthouse.smarthouse.repository.HouseRepository;
import com.smarthouse.smarthouse.service.HouseService;
import com.smarthouse.smarthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private UserService userService;

    @Override
    public House save(House house) {
        checkSave(house);
        return houseRepository.save(house
                .setTemperature(0.0f)
                .setHumidity(0.0f));
    }

    @Override
    public House save(String name,
                      String serial) {
        return houseRepository.save(new House()
                .setName(replaceLastSpace(name))
                .setSerial(replaceLastSpace(serial))
                .setActive(true)
                .setTemperature(0.0f)
                .setHumidity(0.0f));
    }

    @Override
    public House update(House house) {
        checkObjectExistsById(house.getId(), houseRepository);
        return houseRepository.save(house);
    }

    @Override
    public House update(Long id,
                        String name,
                        String serial,
                        Float temperature,
                        Float humidity) {
        checkObjectExistsById(id, houseRepository);
        House house = findOne(id)
                .setName(replaceLastSpace(name))
                .setSerial(replaceLastSpace(serial))
                .setTemperature(temperature)
                .setHumidity(humidity);
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

    @Override
    public House createOrFindBySerial(String serial, Principal principal) {
        checkString(serial);
        House house = findBySerial(serial);
        User user = userService.findByEmail(principal.getName());
        if (house == null) {
            house = save(new House().setSerial(serial));
            userService.update(user.setHouse(house));
            return house;
        } else {
            userService.update(user.setHouse(house));
            return house;
        }
    }

    private String replaceLastSpace(String s) {
        if (s.endsWith(" "))
            return s.substring(0, s.length() - 1);
        else
            return s;
    }
}
