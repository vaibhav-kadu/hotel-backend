package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookingRepository extends JpaRepository<RoomBooking, Long> {
}
