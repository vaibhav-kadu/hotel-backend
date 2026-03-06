package com.vkmaster.hotelmanagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableDTO {

    @NotNull
    private Integer tableNumber;

    @NotNull
    private Integer capacity;
}
