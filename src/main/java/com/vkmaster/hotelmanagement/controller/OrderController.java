package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.OrderRequestDTO;
import com.vkmaster.hotelmanagement.entity.OrderEntity;
import com.vkmaster.hotelmanagement.entity.OrderStatusEntity;
import com.vkmaster.hotelmanagement.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderRequestDTO dto){
        return orderService.createOrder(dto);
    }

    @PutMapping("/{id}/status")
    public OrderEntity updateStatus(@PathVariable Long id, @RequestParam OrderStatusEntity status){
        return orderService.updateOrderStatus(id, status);
    }

    @GetMapping("/status/{status}")
    public List<OrderEntity> getOrdersByStatus(@PathVariable OrderStatusEntity status){
        return orderService.getOrdersByStatus(status);
    }
}
