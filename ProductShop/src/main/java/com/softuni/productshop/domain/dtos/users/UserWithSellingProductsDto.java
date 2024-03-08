package com.softuni.productshop.domain.dtos.users;

import com.softuni.productshop.domain.dtos.products.ProductWithBuyerDto;
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
    private Set<ProductWithBuyerDto> sellingProducts;
}
