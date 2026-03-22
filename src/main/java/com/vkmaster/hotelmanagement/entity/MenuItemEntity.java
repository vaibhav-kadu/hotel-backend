package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name="menu_items")

public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private double price;
    private boolean available;
    public MenuItemEntity(){}


}
