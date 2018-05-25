package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.User;
import com.smarthouse.smarthouse.repository.UserRepository;
import com.smarthouse.smarthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        checkSave(user);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        checkObjectExistsById(user.getId(), userRepository);
        return userRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        checkId(id);
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            checkObjectExistsById(id, userRepository);
            userRepository.delete(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public User findByUsername(String username) {
        checkString(username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllByHouseId(Long houseId) {
        checkId(houseId);
        return userRepository.findAllByHouse_Id(houseId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
