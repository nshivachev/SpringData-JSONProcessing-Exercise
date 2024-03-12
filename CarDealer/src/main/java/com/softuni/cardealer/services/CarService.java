package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNameAndPriceDto;

import java.io.IOException;
import java.util.List;

public interface CarService {
    List<CarWithMakeAndModelAndDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make) throws IOException;

    List<CarWithPartsWithNameAndPriceDto> findAllWithPartsWithNameAndPrice() throws IOException;
}
