package com.mapstruct.demo.dto;

import com.mapstruct.demo.model.Customer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    private Long id;
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String status;
    private Boolean isDefault;

}
