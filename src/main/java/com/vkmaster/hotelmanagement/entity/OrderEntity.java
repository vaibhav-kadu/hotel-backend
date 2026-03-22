package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatusEntity status;

    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name="table_id")
    private TableEntity table;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    public OrderEntity(){}


}
