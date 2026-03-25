package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.HallBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallBookingRepository extends JpaRepository<HallBooking, Long> {
}
