package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tables")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int tableNumber;
    private int capacity;
    private String status;

    public TableEntity(){}

    public TableEntity(long id, int tableNumber, int capacity, String status) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.status = status;
    }
}
