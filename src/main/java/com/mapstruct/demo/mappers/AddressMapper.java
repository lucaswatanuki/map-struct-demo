package com.mapstruct.demo.mappers;

import com.mapstruct.demo.dto.AddressDto;
import com.mapstruct.demo.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto mapToAddressDto(Address address);

    Address mapToAddressEntity(AddressDto dto);
}
