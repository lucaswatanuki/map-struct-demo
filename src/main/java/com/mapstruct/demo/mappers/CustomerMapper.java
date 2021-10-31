package com.mapstruct.demo.mappers;

import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Customer;
import com.mapstruct.demo.service.CPFService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public abstract class CustomerMapper {

    @Autowired
    protected CPFService cpfService;

    @Mapping(target = "cpf", expression = "java(cpfService.formatCpf(dto.getCpf()))")
    public abstract Customer mapToCustomerEntity(CustomerDto dto);

    public abstract CustomerDto mapToCustomerDto(Customer customer);
}
