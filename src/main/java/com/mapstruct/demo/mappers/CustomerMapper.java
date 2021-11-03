package com.mapstruct.demo.mappers;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import com.mapstruct.demo.service.CPFService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface CustomerMapper {

    Customer mapToCustomerEntity(CustomerDto dto);

    CustomerDto mapToCustomerDto(Customer customer);
}
