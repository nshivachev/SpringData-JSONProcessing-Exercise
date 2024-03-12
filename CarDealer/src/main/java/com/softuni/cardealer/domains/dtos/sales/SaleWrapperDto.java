package com.softuni.cardealer.domains.dtos.sales;

import com.google.gson.annotations.SerializedName;
import com.softuni.cardealer.domains.dtos.cars.ImportCarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleWrapperDto {
    private ImportCarDto car;
    private String customerName;
    @SerializedName("Discount")
    private Float discount;
    BigDecimal price;
    BigDecimal priceWithDiscount;
}
