package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeModelDistanceDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNamePriceDto;

import java.io.IOException;
import java.util.List;

public interface CarService {
    List<CarWithMakeModelDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make) throws IOException;

    List<CarWithPartsWithNamePriceDto> findAllWithPartsWithNameAndPrice() throws IOException;
}
