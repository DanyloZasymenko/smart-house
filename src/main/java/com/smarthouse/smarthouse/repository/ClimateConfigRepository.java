package com.smarthouse.smarthouse.repository;

import com.smarthouse.smarthouse.model.ClimateConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateConfigRepository extends JpaRepository<ClimateConfig, Long>{

}
