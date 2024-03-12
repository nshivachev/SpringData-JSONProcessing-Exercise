package com.softuni.cardealer.domains.dtos.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWrapperDto {
    private String name;
    private Long boughtCars;
    private BigDecimal spentMoney;
}
