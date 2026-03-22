package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
}
