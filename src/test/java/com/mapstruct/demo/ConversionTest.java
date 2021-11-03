package com.mapstruct.demo;

import com.mapstruct.demo.dto.AddressDto;
import com.mapstruct.demo.dto.CarDto;
import com.mapstruct.demo.dto.CustomerDto;
import com.mapstruct.demo.mappers.*;
import com.mapstruct.demo.model.*;
import com.mapstruct.demo.service.CPFService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(classes = {CustomerMapperImpl.class, AddressMapperImpl.class})
public class ConversionTest {

    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void shouldConvertCustomer() {
        CustomerDto source = CustomerDto
                .builder()
                .firstName("Lucas")
                .lastName("Watanuki")
                .cpf("46901514824")
                .alias("lwata")
                .email("lucas@gmail.com")
                .emailNotification(true)
                .phoneNumber("13996634819")
                .alternativePhoneNumber("")
                .customerSince(LocalDate.now())
                .birthDay(LocalDate.of(1996, 10, 14))
                .newsletter(false)
                .defaultShipMethod(ShipMethod.SEDEX)
                .address(singletonList(AddressDto.builder()
                        .streetAddress("rua 4")
                        .streetAddress2("")
                        .zipCode("13501-050")
                        .city("Rio Claro")
                        .state("SP")
                        .country("Brazil")
                        .status("active")
                        .isDefault(true)
                        .build()))
                .build();

        Customer target = customerMapper.mapToCustomerEntity(source);
        List<Address> targetAddress = target.getAddress();

        assertThat(target).usingRecursiveComparison()
                .ignoringFields("address")
                .isEqualTo(source);

        assertThat(targetAddress).usingRecursiveComparison()
                .ignoringFields("id")
                .ignoringFields("customer")
                .isEqualTo(source.getAddress());
    }

    @Test
    public void shouldConvertUsingBeforeAndAfterMap() {
        Car source = new ElectricCar();
        source.setColor("silver");
        source.setName("siena");
        source.setNumberOfPorts(4);

        CarDto destination = carMapper.toCarDto(source);

        assertEquals(source.getName().toUpperCase(), destination.getName());
        assertEquals(source.getColor(), destination.getColor());
        assertEquals(source.getNumberOfPorts(), destination.getPorts());
    }
}
