package com.vkmaster.hotelmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDTO {

    private Long menuItemId;
    private int quantity;
}
