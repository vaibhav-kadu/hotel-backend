package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.LoginRequestDTO;
import com.vkmaster.hotelmanagement.entity.UserEntity;
import com.vkmaster.hotelmanagement.repository.UserRepository;
import com.vkmaster.hotelmanagement.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public  AuthService(UserRepository userRepository,
                        BCryptPasswordEncoder passwordEncoder,
                        JwtUtil jwtUtil){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    public String login(LoginRequestDTO requestDTO){

        UserEntity user = userRepository.findByUsername(requestDTO.getUsername())
                .orElseThrow(()-> new RuntimeException("User not found"));


        if(!passwordEncoder.matches(requestDTO.getPassword(), user.getPassword())){
            throw  new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
