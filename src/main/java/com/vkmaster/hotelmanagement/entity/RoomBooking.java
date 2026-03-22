package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "room_booking")
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public RoomBooking(){}

}
