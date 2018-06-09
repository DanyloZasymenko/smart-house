package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.User;

import java.util.List;

public interface UserService {

    User save(String name,
              String middleName,
              String lastName,
              String email,
              String password);

    User update(User user);

    User update(Long id,
                String name,
                String middleName,
                String lastName,
                String email);

    User findOne(Long id);

    List<User> findAll();

    Boolean delete(Long id);

    User findByEmail(String email);

    List<User> findAllByHouseId(Long houseId);
}
