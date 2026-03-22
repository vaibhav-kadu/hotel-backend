package com.vkmaster.hotelmanagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RoomBookingDTO {

    @NotNull
    private Long roomId;

    @NotNull
    private Long customer_id;

    @NotNull
    private LocalDate checkIn;

    @NotNull
    private LocalDate checkOut;

}
