package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
