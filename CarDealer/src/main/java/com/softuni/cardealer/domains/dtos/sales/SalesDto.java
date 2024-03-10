package com.softuni.cardealer.domains.dtos.sales;

import com.softuni.cardealer.domains.dtos.cars.CarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesDto {
    private Long id;
    private Float discount;
    private CarDto car;
}
