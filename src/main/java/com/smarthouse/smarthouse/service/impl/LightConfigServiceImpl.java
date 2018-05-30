package com.smarthouse.smarthouse.service.impl;

import com.smarthouse.smarthouse.model.LightConfig;
import com.smarthouse.smarthouse.repository.LightConfigRepository;
import com.smarthouse.smarthouse.service.LightConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

import static com.smarthouse.smarthouse.service.utils.Validation.checkId;
import static com.smarthouse.smarthouse.service.utils.Validation.checkObjectExistsById;

@Service
public class LightConfigServiceImpl implements LightConfigService {

    @Autowired
    private LightConfigRepository lightConfigRepository;

    @Override
    public LightConfig save(Time startTime,
                            Time endTime,
                            Boolean active) {
        return lightConfigRepository.save(new LightConfig()
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setActive(active));
    }

    @Override
    public LightConfig update(Long id,
                              Time startTime,
                              Time endTime,
                              Boolean active) {
        checkObjectExistsById(id, lightConfigRepository);
        LightConfig lightConfig = findOne(id)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setActive(active);
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
