package com.mapstruct.demo;

import com.mapstruct.demo.client.CustomerClient;
import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.model.Address;
import com.mapstruct.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;


class DemoApplicationTests extends ConfigurationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerClient client;

    @Test
    void shouldSaveCustomer() {
        final CustomerDto dto = client.create(CustomerDto.builder()
                .firstName("Lucas")
                .lastName("Watanuki")
                .cpf("46901514824")
                .alias("name")
                .build());

        final List<CustomerDto> customers = client.findAll();

        final CustomerDto customerResponse = customers.get(0);

        assertThat(customerResponse).usingRecursiveComparison()
                .ignoringFields("address")
                .isEqualTo(dto);
    }

}
