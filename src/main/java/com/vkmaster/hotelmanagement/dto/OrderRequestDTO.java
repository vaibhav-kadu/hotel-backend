package com.vkmaster.hotelmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {

    private Long tableId;
    private List<OrderItemDTO> items;
}
