package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.entity.Staff;
import com.vkmaster.hotelmanagement.service.StaffService;
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
    public Staff createStaff(@RequestBody Staff staff){
        return staffService.saveStaff(staff);
    }

    @GetMapping
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

}
