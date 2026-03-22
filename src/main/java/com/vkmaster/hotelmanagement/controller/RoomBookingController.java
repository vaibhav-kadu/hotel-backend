package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.RoomBookingDTO;
import com.vkmaster.hotelmanagement.entity.RoomBooking;
import com.vkmaster.hotelmanagement.service.RoomBookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room-bookings")
public class RoomBookingController {

    private final RoomBookingService bookingService;

    public RoomBookingController(RoomBookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping
    public RoomBooking createBooking(@RequestBody RoomBookingDTO dto){
        return  bookingService.createBooking(dto);
    }
}
