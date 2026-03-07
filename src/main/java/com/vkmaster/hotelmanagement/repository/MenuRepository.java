package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuItemEntity, Long > {
}
