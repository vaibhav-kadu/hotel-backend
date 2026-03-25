package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.HallBookingDTO;
import com.vkmaster.hotelmanagement.entity.HallBooking;
import com.vkmaster.hotelmanagement.service.HallBookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hall-bookings")
public class HallBookingController {

    private final HallBookingService bookingService;

    public HallBookingController(HallBookingService bookingService){
        this.bookingService=bookingService;
    }

    @PostMapping
    public HallBooking createBooking(@RequestBody HallBookingDTO dto){
        return bookingService.createBooking(dto);
    }

}
