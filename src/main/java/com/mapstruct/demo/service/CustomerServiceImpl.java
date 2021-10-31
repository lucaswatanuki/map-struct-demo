package com.mapstruct.demo.service;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.mappers.CustomerMapper;
import com.mapstruct.demo.model.Customer;
import com.mapstruct.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                 .map(customer -> mapper.mapToCustomerDto(customer))
                 .collect(Collectors.toList());
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        final Customer customerEntity = customerRepository.save(mapper.mapToCustomerEntity(customerDto));
        return mapper.mapToCustomerDto(customerEntity);
    }
}
