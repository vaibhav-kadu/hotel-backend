package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private  Double pricePerDay;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    public Room(){}
}
