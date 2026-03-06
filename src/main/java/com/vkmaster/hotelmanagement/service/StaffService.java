package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.StaffDTO;
import com.vkmaster.hotelmanagement.entity.StaffEntity;
import com.vkmaster.hotelmanagement.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public StaffEntity saveStaff(StaffDTO dto){

        StaffEntity staffEntity = new StaffEntity();

        staffEntity.setName(dto.getName());
        staffEntity.setRole(dto.getRole());
        staffEntity.setPhone(dto.getPhone());

        return staffRepository.save(staffEntity);
    }

    public List<StaffEntity> getAllStaff(){
        return staffRepository.findAll();
    }
}
