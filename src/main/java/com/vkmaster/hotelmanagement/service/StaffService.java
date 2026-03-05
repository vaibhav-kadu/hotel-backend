package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.entity.Staff;
import com.vkmaster.hotelmanagement.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff saveStaff(Staff staff){
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }
}
