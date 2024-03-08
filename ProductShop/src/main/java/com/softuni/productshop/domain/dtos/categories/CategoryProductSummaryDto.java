package com.softuni.productshop.domain.dtos.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProductSummaryDto {
    private String name;
    private Long productsCount;
    private Double averagePrice;
    private BigDecimal totalRevenue;
}
