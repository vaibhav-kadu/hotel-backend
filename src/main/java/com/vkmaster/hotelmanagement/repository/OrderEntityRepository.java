package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}
