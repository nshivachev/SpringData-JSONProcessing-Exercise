package com.softuni.cardealer.domains.dtos.suppliers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportSupplierDto {
    private String name;
    private boolean isImporter;
}
