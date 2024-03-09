package com.softuni.cardealer.domains.dtos.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportCarDto {
    private String make;
    private String model;
    private Long travelledDistance;
}
