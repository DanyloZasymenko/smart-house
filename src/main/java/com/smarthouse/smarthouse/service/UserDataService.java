package com.smarthouse.smarthouse.service;


import com.smarthouse.smarthouse.model.UserData;

import java.util.List;

public interface UserDataService {

    UserData save(UserData userData);

    UserData update(UserData userData);

    UserData findOne(Long id);

    List<UserData> findAll();

    Boolean delete(Long id);

    List<UserData> findAllByUserId(Long userId);

    List<UserData> findAllByDeviceId(Long deviceId);
}