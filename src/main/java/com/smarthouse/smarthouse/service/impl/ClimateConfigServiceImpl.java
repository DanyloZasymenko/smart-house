package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.ClimateConfig;
import com.smarthouse.smarthouse.repository.ClimateConfigRepository;
import com.smarthouse.smarthouse.service.ClimateConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class ClimateConfigServiceImpl implements ClimateConfigService {

    @Autowired
    private ClimateConfigRepository climateConfigRepository;

    @Override
    public ClimateConfig save(ClimateConfig climateConfig) {
        checkSave(climateConfig);
        return climateConfigRepository.save(climateConfig);
    }

    @Override
    public ClimateConfig update(ClimateConfig climateConfig) {
        checkObjectExistsById(climateConfig.getId(), climateConfigRepository);
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
