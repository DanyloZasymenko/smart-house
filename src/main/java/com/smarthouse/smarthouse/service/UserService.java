package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User update(User user);

    User findOne(Long id);

    List<User> findAll();

    Boolean delete(Long id);

    User findByUsername(String username);

    List<User> findAllByHouseId(Long houseId);
}
