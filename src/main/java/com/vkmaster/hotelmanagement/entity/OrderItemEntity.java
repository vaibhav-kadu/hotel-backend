package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItemEntity menuItem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public OrderItemEntity(){}
}
