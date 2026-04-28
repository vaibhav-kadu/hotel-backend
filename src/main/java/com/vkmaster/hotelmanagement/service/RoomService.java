package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.RoomDTO;
import com.vkmaster.hotelmanagement.entity.Room;
import com.vkmaster.hotelmanagement.entity.RoomStatus;
import com.vkmaster.hotelmanagement.exception.BadRequestException;
import com.vkmaster.hotelmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }

    public Room createRoom(RoomDTO dto){

        roomRepository.findByRoomNumber(dto.getRoomNumber())
                .ifPresent(room -> {
                    throw new BadRequestException("Room number already exists");
                });

        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setRoomType(dto.getRoomType());
        room.setPricePerDay(dto.getPricePerDay());
        room.setStatus(RoomStatus.AVAILABLE);

        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getRoomsByStatus(RoomStatus status){
        return roomRepository.findByStatus(status);
    }
}
