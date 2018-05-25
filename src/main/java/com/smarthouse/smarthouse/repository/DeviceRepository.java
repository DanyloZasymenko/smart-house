package com.smarthouse.smarthouse.repository;

import com.smarthouse.smarthouse.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

    Device findByNameAndHouse_Id(String name, Long house_id);

    List<Device> findAllByHouse_Id(Long house_id);

    List<Device> findAllByIsActiveAndHouse_Id(Boolean isActive, Long house_id);
}
