package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.RoomDTO;
import com.vkmaster.hotelmanagement.entity.Room;
import com.vkmaster.hotelmanagement.entity.RoomStatus;
import com.vkmaster.hotelmanagement.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private  final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @PostMapping
    public Room createRoom(@RequestBody RoomDTO dto){
        return roomService.createRoom(dto);
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/status/{status}")
    public List<Room> getRoomsByStatus(@PathVariable RoomStatus status) {
        return roomService.getRoomsByStatus(status);
    }
}
