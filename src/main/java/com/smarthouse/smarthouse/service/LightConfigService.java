package com.smarthouse.smarthouse.service;

import com.smarthouse.smarthouse.model.LightConfig;

import java.util.List;

public interface LightConfigService {

    LightConfig save(LightConfig lightConfig);

    LightConfig update(LightConfig lightConfig);

    LightConfig findOne(Long id);

    List<LightConfig> findAll();

    Boolean delete(Long id);
}
