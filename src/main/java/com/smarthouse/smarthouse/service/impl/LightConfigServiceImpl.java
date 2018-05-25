package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.LightConfig;
import com.smarthouse.smarthouse.repository.LightConfigRepository;
import com.smarthouse.smarthouse.service.LightConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.*;

@Service
public class LightConfigServiceImpl implements LightConfigService {

    @Autowired
    private LightConfigRepository lightConfigRepository;

    @Override
    public LightConfig save(LightConfig lightConfig) {
        checkSave(lightConfig);
        return lightConfigRepository.save(lightConfig);
    }

    @Override
    public LightConfig update(LightConfig lightConfig) {
        checkObjectExistsById(lightConfig.getId(), lightConfigRepository);
        return lightConfigRepository.save(lightConfig);
    }

    @Override
    public LightConfig findOne(Long id) {
        checkId(id);
        return lightConfigRepository.findOne(id);
    }

    @Override
    public List<LightConfig> findAll() {
        return lightConfigRepository.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            checkObjectExistsById(id, lightConfigRepository);
            lightConfigRepository.delete(id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
