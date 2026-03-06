package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.StaffDTO;
import com.vkmaster.hotelmanagement.entity.Staff;
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
    public ResponseEntity<Staff> createStaff(@Valid @RequestBody StaffDTO dto){
        Staff staff = staffService.saveStaff(dto);
        return ResponseEntity.ok(staff);
    }

    @GetMapping
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

}
