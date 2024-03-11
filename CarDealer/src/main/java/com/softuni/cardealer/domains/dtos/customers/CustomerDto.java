package com.softuni.cardealer.domains.dtos.customers;

import com.softuni.cardealer.domains.dtos.sales.SalesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private boolean youngDriver;
    private Set<SalesDto> sales;
}
