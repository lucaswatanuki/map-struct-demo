package com.mapstruct.demo;

import com.mapstruct.demo.dto.CarDto;
import com.mapstruct.demo.mappers.CarMapper;
import com.mapstruct.demo.model.Car;
import com.mapstruct.demo.model.ElectricCar;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarConversionTest {

    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    @Test
    public void givenSourceToDestination_whenMaps_thenCorrect() {
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
