package com.softuni.cardealer.domains.dtos.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportCustomerDto {
    private String name;
    private LocalDateTime birthDate;
    private boolean youngDriver;
}
