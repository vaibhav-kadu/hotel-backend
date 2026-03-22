package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByStatus(OrderStatusEntity status);
}
