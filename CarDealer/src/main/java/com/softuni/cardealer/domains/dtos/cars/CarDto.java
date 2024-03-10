package com.softuni.cardealer.domains.dtos.cars;

import com.softuni.cardealer.domains.dtos.parts.PartDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private String make;
    private String model;
    private Long travelledDistance;
    private Set<PartDto> parts;
}
