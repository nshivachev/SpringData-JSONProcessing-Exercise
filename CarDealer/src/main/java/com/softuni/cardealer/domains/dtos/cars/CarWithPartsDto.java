package com.softuni.cardealer.domains.dtos.cars;

import com.softuni.cardealer.domains.dtos.parts.PartWithPriceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarWithPartsDto {
    private Set<PartWithPriceDto> parts;
}
