package com.vkmaster.hotelmanagement.repository;

import com.vkmaster.hotelmanagement.entity.Room;
import com.vkmaster.hotelmanagement.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumber(Integer roomNumber);

    List<Room> findByStatus(RoomStatus status);
}
