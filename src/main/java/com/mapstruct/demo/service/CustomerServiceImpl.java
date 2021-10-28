package com.mapstruct.demo.service;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import com.mapstruct.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(CustomerDto customerDto) {

        customerRepository.save(Customer.builder()
                .alias("teste")
                .build());
    }
}
