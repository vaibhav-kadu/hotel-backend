package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.*;
import com.vkmaster.hotelmanagement.entity.*;
import com.vkmaster.hotelmanagement.exception.ResourceNotFoundException;
import com.vkmaster.hotelmanagement.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@Service
public class OrderService {

    private final TableRepository tableRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    public OrderService(TableRepository tableRepository,
                        MenuRepository menuRepository, OrderRepository orderRepository){
        this.tableRepository=tableRepository;
        this.menuRepository=menuRepository;
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderRequestDTO dto){
        TableEntity table = tableRepository.findById(dto.getTableId())
                .orElseThrow(()-> new ResourceNotFoundException("Table Not Found"));

        OrderEntity order = new OrderEntity();
        order.setTable(table);
        order.setStatus(OrderStatusEntity.CREATED);
        order.setCreatedTime(LocalDateTime.now());

        List<OrderItemEntity> orderItems = new ArrayList<>();

        for(OrderItemDTO itemDTO : dto.getItems()){
            MenuItemEntity menuItem = menuRepository.findById(itemDTO.getMenuItemId())
                    .orElseThrow(()-> new ResourceNotFoundException("Menu Item not found"));

            OrderItemEntity item = new OrderItemEntity();
            item.setMenuItem(menuItem);
            item.setQuantity(itemDTO.getQuantity());
            item.setOrder(order);

            orderItems.add(item);
        }

        order.setItems(orderItems);

        return orderRepository.save(order);
    }

    public OrderEntity updateOrderStatus(Long orderId, OrderStatusEntity status){
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public List<OrderEntity> getOrdersByStatus(OrderStatusEntity status){
        return orderRepository.findByStatus(status);
    }
}
