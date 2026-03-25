package com.vkmaster.hotelmanagement.dto;

import com.vkmaster.hotelmanagement.entity.EventType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HallBookingDTO {

    @NotNull
    private Long hallId;

    @NotNull
    private Long customerId;

    @NotNull
    private LocalDate eventDate;

    @NotNull
    private EventType eventType;

    private boolean foodRequired;
}
