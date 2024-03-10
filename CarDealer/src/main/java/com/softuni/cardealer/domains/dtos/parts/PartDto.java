package com.softuni.cardealer.domains.dtos.parts;

import com.softuni.cardealer.domains.dtos.suppliers.SupplierDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartDto {
    private String name;
    private BigDecimal price;
    private int quantity;
    private SupplierDto supplier;
}
