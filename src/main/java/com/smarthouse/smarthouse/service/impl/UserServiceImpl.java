package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.User;
import com.smarthouse.smarthouse.repository.UserRepository;
import com.smarthouse.smarthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(String name, String middleName, String lastName, String email, String password) {
        return userRepository.save(new User()
                .setName(name)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(passwordEncoder.encode(password)));
    }

    @Override
    public User update(Long id, String name, String middleName, String lastName, String email, String password) {
        checkObjectExistsById(id, userRepository);
        User user = findOne(id)
                .setName(name)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(passwordEncoder.encode(password));
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
    public User findByEmail(String email) {
        checkString(email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllByHouseId(Long houseId) {
        checkId(houseId);
        return userRepository.findAllByHouse_Id(houseId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }
}
