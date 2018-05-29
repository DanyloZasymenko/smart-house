package com.smarthouse.smarthouse.repository;

import com.smarthouse.smarthouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

    List<User> findAllByHouse_Id(Long house_id);
}
