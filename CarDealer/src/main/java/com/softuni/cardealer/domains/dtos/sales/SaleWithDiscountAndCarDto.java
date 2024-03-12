package com.softuni.cardealer.domains.dtos.sales;

import com.softuni.cardealer.domains.dtos.cars.CarWithPartsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleWithDiscountAndCarDto {
    private Float discount;
    private CarWithPartsDto car;
}
