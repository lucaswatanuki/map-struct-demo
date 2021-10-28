package com.mapstruct.demo.service;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void create(CustomerDto customerDto);
}
