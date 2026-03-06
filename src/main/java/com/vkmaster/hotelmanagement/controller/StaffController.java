package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.StaffDTO;
import com.vkmaster.hotelmanagement.entity.StaffEntity;
import com.vkmaster.hotelmanagement.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService=staffService;
    }

    @PostMapping
    public ResponseEntity<StaffEntity> createStaff(@Valid @RequestBody StaffDTO dto){
        StaffEntity staffEntity = staffService.saveStaff(dto);
        return ResponseEntity.ok(staffEntity);
    }

    @GetMapping
    public List<StaffEntity> getAllStaff(){
        return staffService.getAllStaff();
    }

}
