package com.mapstruct.demo.mappers;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer mapToCustomerEntity(CustomerDto dto);

    CustomerDto mapToCustomerDto(Customer customer);
}
