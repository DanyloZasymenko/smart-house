package com.smarthouse.smarthouse.repository;

import com.smarthouse.smarthouse.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>{

    List<UserData> findAllByUser_Id(Long user_id);

    List<UserData> findAllByDevice_Id(Long device_id);
}
