package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.HallBookingDTO;
import com.vkmaster.hotelmanagement.entity.Customer;
import com.vkmaster.hotelmanagement.entity.Hall;
import com.vkmaster.hotelmanagement.entity.HallBooking;
import com.vkmaster.hotelmanagement.entity.HallBookingStatus;
import com.vkmaster.hotelmanagement.exception.BadRequestException;
import com.vkmaster.hotelmanagement.exception.ResourceNotFoundException;
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

       Hall hall = getHall(dto.getHallId());
       Customer customer = getCustomer(dto.getCustomerId());

       validateHallAvailability(hall);

       double total = calculateTotal(hall, dto.isFoodRequired());

       HallBooking booking = buildBooking(dto, hall, customer, total);

       updateHallAvailability(hall);

       return bookingRepository.save(booking);
    }

    private Hall getHall(Long id){
        return hallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hall not found"));
    }

    private Customer getCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    private void validateHallAvailability(Hall hall){
        if(!hall.isAvailable()){
            throw  new BadRequestException("Hall not available");
        }
    }

    private double calculateTotal(Hall hall, boolean foodRequired){
        double total = hall.getPricePerDay();

        if(foodRequired){
            total += 5000;  //Increase Price As Per Food for Hall
        }

        return total;
    }

    private HallBooking buildBooking(HallBookingDTO dto, Hall hall, Customer customer, double total){

        HallBooking booking = new HallBooking();
        booking.setHall(hall);
        booking.setCustomer(customer);
        booking.setEventDate(dto.getEventDate());
        booking.setEventType(dto.getEventType());
        booking.setFoodRequired(dto.isFoodRequired());
        booking.setTotalAmount(total);
        booking.setStatus(HallBookingStatus.BOOKED);

        return booking;
    }

    private void  updateHallAvailability(Hall hall){
        hall.setAvailable(false);
        hallRepository.save(hall);
    }
}
