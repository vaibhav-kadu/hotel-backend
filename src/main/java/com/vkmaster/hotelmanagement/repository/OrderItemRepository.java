package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Long> {
}
