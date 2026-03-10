package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.LoginRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO requestDTO){
        //Logic
        return "Login Api created";
    }


}
