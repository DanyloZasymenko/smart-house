package com.smarthouse.smarthouse.repository;

import com.smarthouse.smarthouse.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{

    House findBySerial(String serial);

}
