package com.vkmaster.hotelmanagement.dto;

import com.vkmaster.hotelmanagement.entity.RoomType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {

    @NotNull
    private Integer roomNumber;

    @NotNull
    private RoomType roomType;

    @NotNull
    private Double pricePerDay;

    public  RoomDTO(){}
}
