package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.ClimateConfig;
import com.smarthouse.smarthouse.repository.ClimateConfigRepository;
import com.smarthouse.smarthouse.service.ClimateConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.checkId;
import static com.smarthouse.smarthouse.service.utils.Validation.checkObjectExistsById;

@Service
public class ClimateConfigServiceImpl implements ClimateConfigService {

    @Autowired
    private ClimateConfigRepository climateConfigRepository;

    @Override
    public ClimateConfig save(Double temperature, Time startTime, Time endTime, Boolean active) {
        return climateConfigRepository.save(new ClimateConfig()
                .setTemperature(temperature)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setActive(active));
    }

    @Override
    public ClimateConfig update(Long id, Double temperature, Time startTime, Time endTime, Boolean active) {
        checkObjectExistsById(id, climateConfigRepository);
        ClimateConfig climateConfig = findOne(id)
                .setTemperature(temperature)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setActive(active);
        return climateConfigRepository.save(climateConfig);
    }

    @Override
    public ClimateConfig findOne(Long id) {
        checkId(id);
        return climateConfigRepository.findOne(id);
    }

    @Override
    public List<ClimateConfig> findAll() {
        return climateConfigRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            checkObjectExistsById(id, climateConfigRepository);
            climateConfigRepository.delete(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
