package com.smarthouse.smarthouse.repository;

import com.smarthouse.smarthouse.model.LightConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightConfigRepository extends JpaRepository<LightConfig, Long>{

}
