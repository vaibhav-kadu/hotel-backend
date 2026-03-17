package com.vkmaster.hotelmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    private String email;

    private String idProof;

    private String address;
}
