package com.softuni.productshop.domain.dtos.users;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithSellingProductsDto {
    private String firstName;
    private String lastName;
    private Set<ProductWithNamePriceDto> sellingProducts;
}
