package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableEntity, Long> {
}
