package com.mapstruct.demo.dto;

import com.mapstruct.demo.model.Address;
import com.mapstruct.demo.model.ShipMethod;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Long id;
    private String cpf;
    private String firstName;
    private String lastName;
    private LocalDate customerSince;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private LocalDate birthDay;
    private ShipMethod defaultShipMethod;
    private Boolean emailNotification;
    private Boolean newsletter;
    private String alias;
    private List<AddressDto> address;
}
