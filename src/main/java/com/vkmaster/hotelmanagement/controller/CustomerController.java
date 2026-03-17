package com.vkmaster.hotelmanagement.controller;

import com.vkmaster.hotelmanagement.dto.CustomerDTO;
import com.vkmaster.hotelmanagement.entity.Customer;
import com.vkmaster.hotelmanagement.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerDTO dto){
        return customerService.createCustomer(dto);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
}
