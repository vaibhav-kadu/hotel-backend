package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.LoginRequestDTO;
import com.vkmaster.hotelmanagement.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO requestDTO){
        return authService.login(requestDTO);
    }


}
