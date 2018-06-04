package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.UserData;
import com.smarthouse.smarthouse.repository.UserDataRepository;
import com.smarthouse.smarthouse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ClimateConfigService climateConfigService;

    @Autowired
    private LightConfigService lightConfigService;

    @Override
    public UserData save(UserData userData) {
        checkSave(userData);
        return userDataRepository.save(userData);
    }

    @Override
    public UserData saveForClimateConfig(Long deviceId, Long climateConfigId, Principal principal) {
        UserData userData = new UserData()
                .setUser(userService.findByEmail(principal.getName()))
                .setDevice(deviceService.findOne(deviceId))
                .setClimateConfig(climateConfigService.findOne(climateConfigId));
        return userDataRepository.save(userData);
    }

    @Override
    public UserData saveForLightConfig(Long deviceId, Long lightConfigId, Principal principal) {
        UserData userData = new UserData()
                .setUser(userService.findByEmail(principal.getName()))
                .setDevice(deviceService.findOne(deviceId))
                .setLightConfig(lightConfigService.findOne(lightConfigId));
        return userDataRepository.save(userData);
    }

    @Override
    public UserData update(UserData userData) {
        checkObjectExistsById(userData.getId(), userDataRepository);
        return userDataRepository.save(userData);
    }

    @Override
    public UserData findOne(Long id) {
        checkId(id);
        return userDataRepository.findOne(id);
    }

    @Override
    public List<UserData> findAll() {
        return userDataRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            checkObjectExistsById(id, userDataRepository);
            userDataRepository.delete(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public List<UserData> findAllByUserId(Long userId) {
        checkId(userId);
        return userDataRepository.findAllByUser_Id(userId);
    }

    @Override
    public List<UserData> findAllByDeviceId(Long deviceId) {
        checkId(deviceId);
        return userDataRepository.findAllByDevice_Id(deviceId);
    }
}
