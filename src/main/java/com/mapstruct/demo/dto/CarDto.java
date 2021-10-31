package com.mapstruct.demo.dto;

import com.mapstruct.demo.model.FuelType;
import lombok.Data;

@Data
public class CarDto {
    private String name;
    private String color;
    private int ports;
    private FuelType fuelType;
}
