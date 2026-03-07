package com.vkmaster.hotelmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class MenuItemDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotNull
    private double price;
}
