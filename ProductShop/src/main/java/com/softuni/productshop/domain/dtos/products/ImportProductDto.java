package com.softuni.productshop.domain.dtos.products;

import com.softuni.productshop.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportProductDto {
    private String name;
    private BigDecimal price;
    private User seller;
}
