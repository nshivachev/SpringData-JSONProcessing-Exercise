package com.softuni.cardealer.domains.dtos.suppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierWithNameAndPartsCountDto {
    private Long id;
    private String name;
    private long partsCount;
}
