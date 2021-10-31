package com.mapstruct.demo.mappers;

import com.mapstruct.demo.dto.CarDto;
import com.mapstruct.demo.model.Car;
import com.mapstruct.demo.model.ElectricCar;
import com.mapstruct.demo.model.FlexCar;
import com.mapstruct.demo.model.FuelType;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CarMapper {
    @BeforeMapping
    protected void enrichDTOWithFuelType(Car car, @MappingTarget CarDto carDto) {
        if (car instanceof ElectricCar) {
            carDto.setFuelType(FuelType.ELECTRIC);
        }
        if (car instanceof FlexCar) {
            carDto.setFuelType(FuelType.GASOLINE);
        }
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget CarDto carDto) {
        carDto.setName(carDto.getName().toUpperCase());
    }

    @Mapping(source = "numberOfPorts", target = "ports")
    public abstract CarDto toCarDto(Car car);
}
