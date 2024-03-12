package com.softuni.cardealer.domains.dtos.customers;

import com.softuni.cardealer.domains.dtos.sales.SaleWithDiscountAndCarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWithNameAndSalesDto {
    private String name;
    private Set<SaleWithDiscountAndCarDto> sales;

    public CustomerWrapperDto toCustomerWrapperDto() {
        List<BigDecimal> partsPrices = new ArrayList<>();

        sales.forEach(sale -> sale.getCar().getParts()
                .forEach(part -> partsPrices.add(part.getPrice().add(part.getPrice().multiply(BigDecimal.valueOf(sale.getDiscount()))))));

        BigDecimal spentMoney = partsPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CustomerWrapperDto(name, (long) sales.size(), spentMoney.setScale(2, RoundingMode.HALF_UP));
    }
}
