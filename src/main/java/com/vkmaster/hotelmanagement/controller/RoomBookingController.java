package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.RoomBookingDTO;
import com.vkmaster.hotelmanagement.entity.RoomBooking;
import com.vkmaster.hotelmanagement.service.RoomBookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('HOTEL_STAFF')")
    @PutMapping(name = "/{id}/checkout")
    public RoomBooking checkout(@PathVariable Long id){
        return bookingService.checkout(id);
    }
}
