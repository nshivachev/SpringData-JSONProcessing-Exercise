package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeModelDistanceDto;

import java.io.IOException;
import java.util.List;

public interface CarService {
    List<CarWithMakeModelDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make) throws IOException;
}
