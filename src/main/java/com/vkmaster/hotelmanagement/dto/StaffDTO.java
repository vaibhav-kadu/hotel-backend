package com.vkmaster.hotelmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StaffDTO {

    @NotBlank(message="Name is Required")
    private String name;

    @NotBlank(message = "Role is Required")
    private String role;

    @Pattern( regexp =  "\\d{10}", message = "Phone Must be 10 Digits")
    private String phone;

}
