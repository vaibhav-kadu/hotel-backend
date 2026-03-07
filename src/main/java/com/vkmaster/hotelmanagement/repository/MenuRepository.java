package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuItem, Long > {
}
