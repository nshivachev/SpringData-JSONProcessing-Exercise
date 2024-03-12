package com.softuni.cardealer.domains.dtos.sales;

import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNameAndPriceDto;
import com.softuni.cardealer.domains.dtos.customers.CustomerWithNameDto;
import com.softuni.cardealer.domains.dtos.parts.PartWithNameAndPriceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleWithDiscountAndCarAndCustomerDto {
    private Float discount;
    private CarWithPartsWithNameAndPriceDto car;
    private CustomerWithNameDto customer;

    public SaleWrapperDto toSaleWrapperDto() {
        BigDecimal price = car.getParts().stream()
                .map(PartWithNameAndPriceDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal priceWithDiscount = price.add(price.multiply(BigDecimal.valueOf(discount)));

        return new SaleWrapperDto(car.toImportCarDto(), customer.getName(), discount, price, priceWithDiscount);
    }
}
