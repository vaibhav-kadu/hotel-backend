package com.vkmaster.hotelmanagement.service;

import com.vkmaster.hotelmanagement.dto.CustomerDTO;
import com.vkmaster.hotelmanagement.entity.Customer;
import com.vkmaster.hotelmanagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public Customer createCustomer(CustomerDTO dto){
        Customer customer = new Customer();
            customer.setName(dto.getName());
            customer.setPhone(dto.getPhone());
            customer.setEmail(dto.getEmail());
            customer.setIdProof(dto.getIdProof());
            customer.setAddress(dto.getAddress());
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
