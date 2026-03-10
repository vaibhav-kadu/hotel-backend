package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String  username);
}
