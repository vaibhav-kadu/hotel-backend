package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.RoomBookingDTO;
import com.vkmaster.hotelmanagement.entity.*;
import com.vkmaster.hotelmanagement.repository.CustomerRepository;
import com.vkmaster.hotelmanagement.repository.RoomBookingRepository;
import com.vkmaster.hotelmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class RoomBookingService {

    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private  final RoomBookingRepository bookingRepository;

    public RoomBookingService(
            RoomRepository roomRepository,
            CustomerRepository customerRepository,
            RoomBookingRepository bookingRepository
    ){
        this.roomRepository=roomRepository;
        this.customerRepository=customerRepository;
        this.bookingRepository=bookingRepository;
    }

    public RoomBooking createBooking(RoomBookingDTO dto){
        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Customer customer = customerRepository.findById(dto.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if(room.getStatus() != RoomStatus.AVAILABLE){
            throw new RuntimeException("Room is not available");
        }

        Long days = ChronoUnit.DAYS.between(dto.getCheckIn(), dto.getCheckOut());

        double totalAmount = days * room.getPricePerDay();

        RoomBooking booking = new RoomBooking();
            booking.setRoom(room);
            booking.setCustomer(customer);
            booking.setCheckIn(dto.getCheckIn());
            booking.setCheckOut(dto.getCheckOut());
            booking.setTotalAmount(totalAmount);
            booking.setStatus(BookingStatus.BOOKED);

            room.setStatus(RoomStatus.OCCUPIED);

            roomRepository.save(room);

        return  bookingRepository.save(booking);
    }
}
