package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.HallBookingDTO;
import com.vkmaster.hotelmanagement.entity.Customer;
import com.vkmaster.hotelmanagement.entity.Hall;
import com.vkmaster.hotelmanagement.entity.HallBooking;
import com.vkmaster.hotelmanagement.entity.HallBookingStatus;
import com.vkmaster.hotelmanagement.repository.CustomerRepository;
import com.vkmaster.hotelmanagement.repository.HallBookingRepository;
import com.vkmaster.hotelmanagement.repository.HallRepository;
import org.springframework.stereotype.Service;

@Service
public class HallBookingService {

    private final HallRepository hallRepository;
    private final CustomerRepository customerRepository;
    private final HallBookingRepository bookingRepository;

    public HallBookingService(HallRepository hallRepository,
                              CustomerRepository customerRepository,
                              HallBookingRepository bookingRepository){
        this.hallRepository=hallRepository;
        this.customerRepository=customerRepository;
        this.bookingRepository=bookingRepository;
    }

    public HallBooking createBooking(HallBookingDTO dto){

        Hall hall = hallRepository.findById(dto.getHallId())
                .orElseThrow(() -> new RuntimeException("Hall not found"));

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if(!hall.isAvailable()){
            throw new RuntimeException("Hall not available");
        }

        double total = hall.getPricePerDay();

        if(dto.isFoodRequired()){
            total += 5000;  // Simple food Charges
        }

        HallBooking booking = new HallBooking();
            booking.setHall(hall);
            booking.setCustomer(customer);
            booking.setEventDate(dto.getEventDate());
            booking.setEventType(dto.getEventType());
            booking.setFoodRequired(dto.isFoodRequired());
            booking.setTotalAmount(total);
            booking.setStatus(HallBookingStatus.BOOKED);

        hall.setAvailable(false);
        hallRepository.save(hall);
        return bookingRepository.save(booking);
    }
}
