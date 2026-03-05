package com.vkmaster.hotelmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    private String phone;

    public Staff() {
    }

    public Staff(Long id, String name, String role, String phone) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.phone = phone;
    }

}