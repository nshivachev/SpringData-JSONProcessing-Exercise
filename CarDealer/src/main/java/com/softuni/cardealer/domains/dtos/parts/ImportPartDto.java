package com.softuni.cardealer.domains.dtos.parts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportPartDto {
    private String name;
    private BigDecimal price;
    private int quantity;
}
