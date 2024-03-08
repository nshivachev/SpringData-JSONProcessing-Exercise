package com.softuni.productshop.domain.dtos.users;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceBuyerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithSellingProductsWithBuyerDto {
    private String firstName;
    private String lastName;
    private Set<ProductWithNamePriceBuyerDto> sellingProducts;
}
