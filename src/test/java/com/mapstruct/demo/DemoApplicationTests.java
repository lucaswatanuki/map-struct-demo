package com.mapstruct.demo;

import com.mapstruct.demo.client.CustomerClient;
import com.mapstruct.demo.dto.AddressDto;
import com.mapstruct.demo.dto.CarDto;
import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.mappers.CarMapper;
import com.mapstruct.demo.model.Car;
import com.mapstruct.demo.model.ElectricCar;
import com.mapstruct.demo.model.ShipMethod;
import com.mapstruct.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DemoApplicationTests extends ConfigurationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerClient client;

    @Test
    void shouldSaveCustomer() {
        final AddressDto addressDto = AddressDto.builder()
                .city("Rio Claro")
                .build();

        final CustomerDto dto = client.create(CustomerDto.builder()
                .firstName("Lucas")
                .lastName("Watanuki")
                .cpf("46901514824")
                .alias("name")
                .defaultShipMethod(ShipMethod.SEDEX)
                .address(singletonList(addressDto))
                .build());

        final List<CustomerDto> customers = client.findAll();

        final CustomerDto customerResponse = customers.get(0);

        assertThat(customerResponse).usingRecursiveComparison()
                .isEqualTo(dto);
    }
}
