package com.softuni.productshop.domain.dtos.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithNamePriceBuyerDto {
    private String name;
    private BigDecimal price;
    private String buyerFirstName;
    private String buyerLastName;
}
