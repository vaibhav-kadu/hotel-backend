package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.*;
import com.vkmaster.hotelmanagement.entity.*;
import com.vkmaster.hotelmanagement.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@Service
public class OrderService {

    private final TableRepository tableRepository;
    private final MenuRepository menuRepository;
    private final OrderEntityRepository orderEntityRepository;

    public OrderService(TableRepository tableRepository,
                        MenuRepository menuRepository, OrderEntityRepository orderEntityRepository){
        this.tableRepository=tableRepository;
        this.menuRepository=menuRepository;
        this.orderEntityRepository = orderEntityRepository;
    }

    public OrderEntity createOrder(OrderRequestDTO dto){
        TableEntity table = tableRepository.findById(dto.getTableId())
                .orElseThrow(()-> new RuntimeException("Table Not Found"));

        OrderEntity order = new OrderEntity();
        order.setTable(table);
        order.setStatus("CREATED");
        order.setCreatedTime(LocalDateTime.now());

        List<OrderItemEntity> orderItems = new ArrayList<>();

        for(OrderItemDTO itemDTO : dto.getItems()){
            MenuItemEntity menuItem = menuRepository.findById(itemDTO.getMenuItemId())
                    .orElseThrow(()-> new RuntimeException("Menu Item not found"));

            OrderItemEntity item = new OrderItemEntity();
            item.setMenuItem(menuItem);
            item.setQuantity(itemDTO.getQuantity());
            item.setOrder(order);

            orderItems.add(item);
        }

        order.setItems(orderItems);

        return orderEntityRepository.save(order);
    }

    public List<OrderEntity> getOrders(){
        return orderEntityRepository.findAll();
    }
}
